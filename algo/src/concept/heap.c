#define MAX_ELEMENT 200

// key 값을 가지는 element struct를 지정
typedef struct {
    int key;
} element;

// heap[MAX_ELEMENT] 배열을 가지고, heap_size를 가지는 HeapType이라는 struct를 선언
typedef struct
{
    element heap[MAX_ELEMENT];
    int heap_size;
} HeapType;

// 생성 방법 : HeapType heap;
// 동적 생성 방법 : HeapType *heap = create();

// 히프 트리에서의 삽입 함수
// 현재 요소의 개수가 heap_size인 히프 h에 item을 삽입한다
// 삽입 함수

void insert_max_heap(HeapType* h, element item) {
    int i;
    i = ++(h -> heap_size);

    // 트리를 거슬러 올라가면서 부모 노드와 비교하는 과정
    while ((i != 1) && (item.key > h->heap[i/2].key)){
        h->heap[i] = h->heap[i/2]; //i번째 있는 것을 바꾼다. 부모 노드에 해당하는 것을 내 위치로 내리는 것이다.
        i /= 2; //바꿨으니까 부모 노드로 거슬러 올라가깅
    }
    h->heap[i] = item; //계속 최종 정해진 위치에 item을 넣는다~
}

//히프 트리에서의 삭제 함수
//현재 요소의 개수가 heap_size인 히프 h에서 최대 값을 삭제한다. (최소힙일 경우는 최솟값)

element delete_max_heap(HeapType* h){
    element removed; //삭제할 루트 (최댓값)
    element tmp; //마지막 노드를 임시 저장
    int parent, child;

    if(h->heap_size == 0){
        //힙이 비어있으면 에러처리한다.
        removed.key = 0;
        return removed;
    }

    // 루트 노드를 저장
    removed = h->heap[1];

    // 마지막 노드를 tmp에 저장하고, heap_size 감소시킨다.
    tmp = h->heap[h->heap_size--]; 

    // 루트에서부터 내려가면서 자리를 찾는다.
    parent = 1; //root 부터 시작
    child = 2; //왼쪽부터 시작해서 가장 큰 child 찾아야 함,

    while(child <= h->heap_size){
        //오른쪽 자식이 더 클 경우, child를 오른쪽으로 이동한다.
        if(child < h->heap_size && h->heap[child].key < h->heap[child + 1].key){
            child++;
        }

        // tmp가 자식보다 클 경우, tmp는 그 parent 자리로 고정한다.
        if(tmp.key >= h->heap[child].key){
            break;
        }

        //자식 노드를 한 단계 위로 끌어올린다. root 빠졌으니깐
        h->heap[parent] = h->heap[child];

        //비교 했으니 이제 내려가기
        parent = child;
        child *= 2; //다음 단계로 내려간다.
    }

    //tmp를 최종 위치에 저장한다.
    h->heap[parent] = tmp;

    //삭제된 최종 리스트를 반환한다.
    return removed;
}