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
// 현재 요쇠의 개수가 heap_size인 히프 h에 item을 삽입한다
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