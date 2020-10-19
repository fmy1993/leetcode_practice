1. 通过将求两数和种类转化为和与一数差和另一数比值，降低分支数量（加数分别都有两组(集合)，计算的话相当于从两个集合随机选数，不存在函数，把set(a)+set(b) = c,随便移一个数到右边，c-set(a)=set(b)，任意一个a右边的值是唯一的，可以看成f(a)=b，这就找到了hash函数，那么就可以用dict来使查找变为O(1)

2. 数组中可能存在相同元素或者自己，因此需利用dist的value以及数组下标来**避免重复**，并且数组下标要存在dict的value中（因此**数组可以看成一种特殊的dict**,所以数组和dict都可以按照一样的方法来思考）, Use hashmap to reduce search time complexity.

 Map<Integer, Integer> map = new HashMap<>();

​    for (int i = 0; i < nums.length; i++) {

​      map.put(nums[i], i);//近似 ， map.put(nums[i], i);//绝对

​    }

3. 总结：凡是需要两次遍历数组的算法，从中取出两个数，都可以建立一个dict，key找合适的**hash函数**，value存的是数组下标来**避免重复**降低算法时间复杂度

