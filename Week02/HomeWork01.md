#### 关于HashMap的总结
1. HashMap是一个使用散列表实现的Key-Value形式数据结构
2. 底层数据结构使用的是数组
3. Hash冲突：
```
HashMap采用链表来解决Hash冲突；即：对Key进行Hash后将相同Hash的元素存在一个链表中；
当链表长度达到某一个阈值时(值为8), 链表会树化转为一颗红黑树；
当链表长度小于阈值时，红黑树会转为链表。
```
4. Hash实现：
```
如果key为null，则hash值为0
如果key不为null，则取key的hashCode；并对hashCode的高16位与低16位做异或运算，目的为了降低hash冲突
```
5. hash值与数组下标的映射
```
通过取模的形式将hash值对应到数组的下标中；具体形式是: hash & (size - 1) ；数组size为2的N次方
```
6. 数组扩容(resize方法)
```
1 初始大小16，默认装载因子0.75
2 扩容；当table长度大于0以后，扩容的方式是：double老的大小
3 老数据迁移；
    1）如果当前位置只有一个数据，则重新取模分配到新的table中；
    2) 如果当前元素是一个树节点，则将树节点重新分为高低两个链表（或树）分别放在j和j+oldCap位置
    3）如果当前元素是一个链表，则将链表重新分为高低两个链表，分别放在j和j + oldCap的位置
```



