package day10;
/**
 * 多线程如果要使用Queue，但是不安全（一个入队（size先加1若此时时间片用完），
 * 一个出队（看到size为1，但实际取出为null））。
 * BlockingQueue实现双缓冲，线程安全且效率较高。
 * 方法和Queue的一样，实现类如下：
 * ArrayBlockingQueue规定大小，fifo
 * LinkedBlockingQueue fifo大小不定（可以指定）若不制定默认为Integer.MAX_VALUE//应用最广泛
 * PriorityBlockingQueue依据对象比较排序，非fifo
 * SynchronousQueue存和取必须交替执行。即只能有一个元素
 * @author wu.jielin
 * 双缓冲（ArrayBlockingQueue）--Queue的话如果指定大小，满了offer就会返回false
 * 但是双缓冲可以设置缓冲时间，次时间内不停尝试offer。时间结束没有成功才返回false
 */




public class BlockingQueueDemo {
}
