Queue & Priority Queue源码分析
--------------------------

#### Queue
* 添加元素: add或offer
* 删除元素: remove或poll
* 获取元素: element或peek

Java中一般使用Queue的实现类是LinkedList
* LinkedList是一个双向链表，使用一个拥有前后指针的Node类表示一个链表节点
* Node构成: 元素值属性, next指针,pre指针
* LinkedList持有头节点(first)和尾节点(last)

###### 添加
* add或offer
* add在LinkedList的队尾添加一个元素
  * 创建一个Node对象N1
  * N1的pre指针指向LinkedList中的last，同时,last的next指针指向N1
  * N1的next指针设置NULL

###### 删除
* remove或poll
* 删除LinkedList的队头的第一个元素
  * 判断LinkedList的first是否为空
  * first不为空时，将first从链表中删除
  * 将first的next指针指向的元素N2作为新的first
  * 将N2的pre指针设置为NULL
  * 将原来的first元素的next指针设置为NULL

###### 删除
* element或peek
* 获取LinkedList的队头第一个元素
  * 如果first不为空，返回first的值
  * 如果first为空，element方法抛异常，peek方法返回NULL

#### PriorityQueue
* PriorityQueue是一个特殊的队列，特殊在删除或者获取的时候，是按照元素的优先级删除或者获取
* java中的PriorityQueue底层采用一维数组实现的大顶堆

###### 添加

