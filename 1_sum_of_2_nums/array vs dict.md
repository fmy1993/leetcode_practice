1.  字典的存储背后的逻辑是散列表，也就是稀疏数组。dict初始化之后，Python解释器会给dict分

配一定的空间，往字典里添加是按顺序添加的。

2. 字典的**key一定要合适**才能发挥作用

3. 字典在内存中存储不像字典是连续的，但是在逻辑上可以看成稀疏数组(重要的是一对对1:1关系)，目的是为了快速取出要的数据

4. 整个的遍历用数组就行（所有语言都有自增，相当于特殊的一组key）,特定的查找用dict,即getvaluebykey(key),都是特定的取出值

5. 对于dict的key应该

   1.尽可能唯一

   2.解决问题时用的哪个值去找就用哪个值

  								 Dict vs Array 

|                                             | Array                  | Dict                                                         |
| ------------------------------------------- | ---------------------- | ------------------------------------------------------------ |
| Order?                                      | Order by numeric index | unordered                                                    |
| traverse                                    | Order by numeric index | 看具体语言实现，有些是随机，有些当存储后就固定了。  无序的不代表随机的，也不代表每次都是随机的。无序的是：你不该对顺序有任何假定，既不能假定有确定顺序，也不能假定没有确定顺序。 |
| traverse Time complexity                    | O(n)                   | O(n)                                                         |
| O(1) search condition ==  Select one from N | Know key(index)        | Know key(anything you define)                                |

