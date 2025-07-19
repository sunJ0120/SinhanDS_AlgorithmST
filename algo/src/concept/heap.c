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
    int parent, child;
    element item, temp;

    item = h->heap[1];
    temp = h->heap[(h->heap_size)--];

    parent = 1;
    child = 2;

    while(child <= h->heap_size){
        //현재 노드의 자식노드 중 좀 더 큰 자식노드를 찾는다.
        //child < h->heap_size 여야 옆에 노드가 존재하는 것이므로 이렇게 잡아둔다.
        if((child < h->heap_size) && (h->heap[child].key) < h->heap[child+1].key){
            child++;
        }

        //root에 올려둔 것이, 지금 child에 해당하는 것보다 클 경우
        if(temp.key >= h->heap[child].key){
            break;
        }

        //바꿔야 한다. 즉, child에 있는 것을 parent로 swap 해야 한다.
        h->heap[parent] = h->heap[child];
        parent = child;
        child *= 2; //아래로 내려간다.
    }
    h->heap[parent] = temp;
    return item; //root에 해당하는 것을 return 한다.
}