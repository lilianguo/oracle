第一轮：问我分布式文件存储系统，一个很大的文件的存取流程是什么。我对这方面不太了解，扯了一点皮毛之后扯不下去了，直接跟面‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌试官说我不太懂呀

Done:
The Maze: 做到 the maze III, 但是前两问不熟
面试官说好吧那我来考你别的吧，于是问了我一道算法题：在棋盘上给一个起点一个终点，判断国际象棋里面的Knight（类似中国象棋里的马）是否能够从起点移到终点。我用的BFS, 但是貌似有更简单的方法。


中午陪经理吃饭，一个半小时，聊得还算愉快
第二轮：问了一些项目里的问题，接下来问我一个full stack的系统如何Debug，讨论了很多细节。。。然后又让我设计一个点歌系统，顾客可以花钱在一个屏幕上点歌。之中问到了哪些歌应该放在前面，我说可以用LRU cache, 于是又让我讲了讲实现，感觉自己讲得不是很清楚。

done LC 56. Merge Intervals
done:347 	Top K Frequent Elements 

done: 这题 属于DFS加BFS, 每次限制深度做dfs, 同时在dfs里需要剪枝 LC 126. Word Ladder II, BFS imp, then discuss how to 
done: 417   Pacific Atlantic Water Flow   
Done: BFS 算法是Leetcode 1091， Shortest path in binary matrix 
Done: 24. swap nodes in pairs
ONSITE 面到了 利口 四 
581. Shortest Unsorted Continuous Subarray 在一个sorted array中找到没有sorted的区间。 
117

String:


sort:
和波浪排序‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌？

Tree: 
done:98 validate binary search tree
done: binary tree 的in-order traversal。follow up是实现morris的写完，在交流的情况下写完了。
        https://leetcode.com/problems/binary-tree-inorder-traversal/solution/ morris 不会
BST insert and delete: 
done: 450. Delete Node in a BST 
done: 701. Insert into a Binary Search Tree

Binary Search 
4. Median of Two Sorted Arrays 
done: 154 稍微改一下。inital array是一个sorted的array，问你shift了多少次才会变成现在的array。做法一摸一样。就是把return的值变成index而已。


List
done:138 Copy List with Random Pointer 
done:147   Insertion Sort List  

LinkedList:
done:  Reverse LinkedList

graph:
done: 207: course schedule 图 topologic sort
1. 给一副有向图 问从a到b能不能到 返回true or false
follow up 输出所以两‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌个点能到的路径


DP:
第二遍 done: 221 maximal square 
done: 518 coin change II 
正在做 LC 45. Jump Game II DP, backtracking

Design Email service and client. 
You drive the conversation and discuss features like how to send ad emails to millions of users. write an email at app and then loss internet connetion. attachment. browse emails with page. edit email in multiple clients and delta update

Design git to support git push, and later search key words and display urls to the files that have the key words.



Cultrure fit discussion. 

Many of them are from Amazon, so they also have the leadership questions like how do you handle disagreement with coworkers/managers, how do you handle when you miss a deadline. describe a case where you need cooperate with multiple teams to deliver something. When you need make an important decision and why you make such a choice, what is the alternatives, pros cons etc. 


1. 给出一个<电影明星，电影作品>的字典和任意两个明星，找出他们之间的关系路径。例：约翰有作品1,2,3，汤姆有作品3,4, 山姆有作品4,5。求汤姆和山姆的路径，是约翰->3-‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌>汤姆->4->山姆.

3. 基本计算器。只有乘和加。再聊聊工作问题。

4. 抬杠者 (意译)，聊聊工作问题。一个小系统设计，两个异地的数据中心，同时是读写库，怎么去同步数据。


我只到了电面：
1. 问一个SQL，具体有两个TABLE，然后求出 每个DEPARTEMENT 的 平均工资‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌是多少， 要 GROUP BY 和 JOIN 一下
2. 问到了 储存 密码，用STRING好 还是用 CHAR [] 好，并说出理由（网上有答案）
3. 脑经急转弯， 有三个人在一个屋子里，每一个人知道自己的工资，但不知道别人的工资，怎么样才能知道三人的平均工资？ 每一个人都不能直接问别人工资是多少
4. 窨井盖为什么是圆的

再发一个我朋友的，电面面到了 2PC
然后 问你 一个DB TABLE 里面有一个 COLUMN 存了性别，问你在这个 COLUMN上加 INDEX 有用吗

onsite:
1. 问了简历。给一个binary tree和target number。return treenode的位置。具体位置可以自己定义。比如按preorder定义，从index0开始标记每个node的位置。


2. lunch interview。和senior manager吃饭两天。我有一年工作经验但是senior还差得很远。很诧异为什么给我面试。。
具体的问题有：1. 和manager有分歧怎么办。2. comment teammate的时候有disagree怎么办。3. 最自豪的一件事。然后深扣细节。
3. 给一个int 2d array表示一个地图。每个点的值表示相对高度。要求从左上角走到右下角。且只能改变一次上下的方向。即，一开始往上走，然后可以有一次机会往下走。如果是平地就不算是改变方向。面试一开始就和我说，他要重点考察我test和另外一个什么能力（忘了，bq相关的）。我和他解释我的思路的时候他会听，但是我转过去写白板的时候他就会开始玩手机。code里面的corner case想了一段时间。给了大概10几分钟。code没有写完打断我问了很多关于test方面的问题。问的大多数问题我都不知道他在问什么。。必挂的一轮


4. 给一个BST和一个target number，可以保证tree里有这个node。要求返回这个number的successor。一开始给了个O(n)的in order traverse的解。然后用stack记录parent找target node给了时间log(n)空间log(n)的解。要求优化空间，去掉stack，用一个variable记录往左子树走的parent，时间O(height), 空间O(1)。follow up是，如果target可能不存在。但是要是要返回比target number大的最小值。用一个variable记录遍历过的点如果比target大就更新。最后return这个点。


5. 两个bar raiser轮番轰炸。1. 收到过哪些negative的feedback。2. 说一下自己miss deadline的事情。3. 和同事有conflict的时候怎么办。还有一些一下子想不起来了。


补充内容 (2019-7-27 14:26):
第二点说的话不通，有很多语病。。我想说的是，和senior manager吃饭聊天。senior manager说要招senior sde。但是我只有一年经验。我很诧异怎么就给我安排了面试。



店面：
‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌      忘记了，不是常规题，需求很长，然后算法简单。最后加问了下Java多线程的问题，AtomicInteger之类。

Onsite：
     OCI很注重Culture fit，所以onsite之前，一定要把Recruiter发的OCI的Value好好看看，然后结合下自己的工作经历。
     第二轮：
             BQ + 算法。算法是binary tree 的in-order traversal。follow up是实现morris的写完，在交流的情况下写完了。
     第三轮：
             HM Lunch Interview。 接近1.5小时的聊天，BQ，问得还是很细的。
     第四轮：
            System Design。 Design Messenger。问了很多问题，细节不少。
     第五轮：
            BQ。又是一个小时的聊天，本来说最后会出一道题的，结果就是结合经历聊天。

我觉得我应该是面的一般，给了offer，但是包不太给力。


第一题：给一张打印的代码，判断这个程序是做什么的，c++程序，好多层循环，实际上是绕着弯子写了bubble sort
第二题：有一大块内存空间（可理解为一个巨大的array），要写ge‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌t(index)和set(index, val)。问题在于如何区分内存空间里原来存储的garbage和新放进去的有用信息。只允许用array，不能用hash table, set...
比如说内存里的某个位置，即使你没有往里面写过有用信息，你也不知道里面是什么（你不能假定里面是０）。那么如果你看到某个位置‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌的内容是－１，你怎么知道是之前写入的有用信息－１呢，还是本来就是－１（garbage)


1. 三哥。第一题：Add 2 binary t‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌rees. 加完之后的新tree，node的位置完全和两个input tree 重合，比如root.val = root1.val + root2.val，如果一个位置只有一个tree有node，另一个tree为空，那么就是node，两个tree都是空的位置最后也是空。follow up要我写unit test，我说assert一下，面试官说不行，要给我hint，问我知不知道serialize and deserialize tree。第二题：一个简单的binary search
2. lunch interview 一个半小时
3. 三哥。一个room，一个robot，一些blocker，一个exit，robot可以走两种step，一种叫一小步move一个unit，一种叫一大步move两个unit。问走出去的最小step。bfs可以解
4. 三哥。第一题 刷题网 斯而流，第二题 刷题网 而是
5. bar raiser。白人大哥。问了一堆bq之后忽然开始做题（？？？）。一个叫flow free的游戏。一个2d board上有各种颜色的点，每种颜色的点有两个，要求把相同颜色的点两两相连，相连时线之间不可以交叉，如果可以满足要求return true，否则return false。自己define input，output。太特么难了吧，我想来想去觉得比airbnb那个boggle game还难。。。
做法应该是dfs里面嵌套dfs，时间复杂度非常非常非常高，我写啊写也写不出来，面试官最后说，这个题很难，我面这个题面试里面还没有人做出来过。
难的好想哭。。。谁会做。。。



1. Hiring Manager 面, 主要聊项目，聊BQ， 聊他们做的东西
2. 算法， 一个‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌叫Flow Free的游戏要求写程序resolve之， 这个应该属于NP hard问题， 后来DFS搞的确实不太好写，写出来以后面官挺满意
3. LC原题 search target in sorted array + search in rotated sorted array, 多谢同胞放水
4. 算法，这一轮来了一个principal， 头发胡子银白跟洪七公似的， 问的是string s2里面出现在string s1里unique character的数量，题目不难，不过follow up挺多，比如S1特别大/S2特别大/单机能存下/单机存不下等等。感觉真正的高手就是能从一个看起来特别简单的题里面问出很多门道啊，问的我一身冷汗。。
5. 系统设计轮，设计K-V store，用户分布在全球，要求尽量低的latency


第一轮 算法 输入一个整数组，和一个整数K 求数组包裹多少个子数组 子数组的和可以被K 乘除  例如 输入 [1,2,3] ‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌,K = 3 返回值是3；显示让写 o(n3) （找出所有子数组求和） 的然后是O(n2)的(用一个sum array) 来做 最后是o（n)的 类似于2 sum 同余定理写的
第二轮 中午吃饭
第三轮 设计 键值对存储 
第四轮 李口德散十伞 要求 二分查找。 注意没变化的情况。 LZ 很笨写出了bug 不过后来自己 修复了
第五轮 李口德艺耳陆 词梯2 原题 bfs + dfs 解决



5.9 加面（60min）：
1. 判断链表有没有环
move up：如何优化空间到 O(1) 快慢指针

2. 利口 LRU


一轮 sys design加半个coding 什么系统能达到三个四个九 
这是两道题 第一是说一个做一个服务 你是中间那个 为上一次提供服务要求是0.9999u‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌p 你需要call另一个系统给你东西 那个系统只能提供到0.999 问你在这个情况下你这个服务怎么做才能满足上面调用你的系统的那个9999的要求。 第二个题就是上面一个数比自己大 下面一个数比自己小 一个无序数组 写个程序转成可以满足要求的那个形式

二轮 和领导吃饭 一个半小时。。 这午饭我都想不吃了。 就是各种问你metrics logs 
四轮 不知道是不是刷题网原题。 就是那个一个连标的单词 哪种字母出现一样次数的单词 最多 用个什么哈希图写写就好，写快了会延展的问些小问题
五轮 两个人过来bq 问问你各种项目经验 目前面试有什么不满的。。




第一轮：
纯code

https://stackoverflow.com/questions/19355646/‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌max-distance-of-a-number-greater-than-a-given-number-in-array

https://stackoverflow.com/questions/9493853/given-an-array-find-out-the-next-smaller-element-for-each-element
这两道题是有难度的，之前没有遇到过，用力想了一会。之前一直以为oracle的题不难。感觉oracle组和组之间的面试难度还是有差异的

第二轮：

印度manager面，bq + 介绍组 + system design + java 多线程 + algorithm design

据了解，oracle会面一些java有关的知识，比如说多线程，单例模式，garbage collection等等，要做好准备



mobile app 如何显示上万个data point。如果所有数据都传输给mobile，很消耗流量。如何设计可以又准确，又快速。一道开放式题目


第一轮：问了tree的bfs, dfs, 然后问了一些课程的内容，问了你会什么design‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌ pattern, 然后让我给我会的各个编程语言打分，问我10年后的工作规划，感觉没有问什么实质性的内容2333
第二轮：先问了简历上的实习经历，然后做了一道coding，类似LRU。又问了你会什么design pattern。之后就是闲聊...

1.‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌ 给一个元素周期表和一个str，问str能否由周期表里面的某些元素组成
3. 吃饭聊天
4. top k
5. basics on test, CICD, log, metrics, canary... 利口 思思尔



西雅图的O‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌CI里一个team，是做O家cloud formation的五轮：
round1:白人小哥哥，人比较nice，互相介绍完以后coding，利口散就死，写完他拍了照片又扯了一些有的没的。
round2:看着是华人，但是名字不像华人，应该是东南亚那边的。算法是利口而舅舅，利口巴斯散，写完拍照片结束，
round3:lunch+hire manager面试， 问了非常多的BQ，感觉这个HM很care我目前工作习惯已经当前老板跟同事对我的评价， 然后让写了个LRU cache
round4:三姐，给一些string，比如"A<B<C", "C<D<E",然后判断这些不等式是否valid，感觉就是判断图是否有环，跟利口而灵气差不多，就说了思路，然后写了代码，然后三姐说可以，然后拍照走了。
round5:一个年纪很大的白人大叔，他自我介绍是team的architect。感觉资历很老，问了很多aws的services的问题，然后又问对目前OCI的产品有了解没，这一轮说得不好，毕竟很多service只是用过，不知道具体的架构。


lamba, cloudformatio, ec2, dynamo db


一共五轮，早‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌上一轮，午饭一轮，下午三轮
第一轮：印度小哥 寒暄两句以后 问知道linux的grep不 答说知道 可以用类似bfs查找 然后问要是让你设计一个类似的function 你要怎么ood？感觉我答得不是特别详细 但小哥也没追问了。然后就是一道类似利口而灵气的题。最后问问题
第二轮：和印度hiring mananager吃饭 就是正常聊天 中间穿插了一些看得出来是他准备的bq。比较有趣的细节是在我提出我还有别家offer以后 hm问我我学校的接offer policy是啥 我马上义正言辞地说“接了就是接了！绝对不能撕！“。。
第三轮：白人大叔 先问了很多简历 然后就是graph找cycle（有向和无向。。）心想woc 这和ms面的一摸一样 活生生跪出来的经验。。。只能秒了 然后是一道开始听到题目描述以为我要跪了的题 结果发现很简单 大概就是一个餐厅有十张桌子 提供reservation function take一个time和一个人数 返回boolean能不能预定成功（成功的同时也就预订了）时间是15分钟的间隔 桌子是一张坐四人 两张拼一起坐六人 三张八人这样 然后一群人来如果大于四人不能分开坐 只能拼桌 最后就是一张桌子只要reserve了就会被reserve固定的45分钟。用个map就能解决。最后问问题
第四轮：白人大哥 开始感觉很高冷 但面着面着感觉人还挺好 结合我project问了很多distributed system的问题还有涉及到load balancer 全程更像是互相讨论找solution 然后就问问题。。。问了一会儿感觉都要聊天了。。大哥说我们再来一道tinyurl吧。。。基本算法基础上讨论了小balance load的问题 然后又接着问问题。。我问你这些distributed system和load balancer的知识是哪些途径学的 他说他原来是在亚麻做app的 刚来的时候啥都不知道 来了以后才学的。。。大哥。。那你考我这么多。。。不过人挺好 最给我提了个醒下一轮是bartender 可以一票否决 多半是要来算法。。我就给他说我有朋友bartender的算法题居然巨简单 他表示难以置信 我说真的看缘分
第五轮：印度大叔bartender 然后我就发现我之前想多了。。。这轮全程bq。。。。。。没啥说的 就是bq 互相问问题


https://www.zhihu.com/question/36734157


https://zhuanlan.zhihu.com/p/80912060



第一轮：给一个二维数组，以及二维数组内的一片区域，让你把这片区域拷贝到另一个区域上去。一开始我说直接拷贝的方法，加一个缓存，防止overlap的情况，follow up的问题是如果不用e‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌xtra space,如何做。我的解决办法是判断目标区域的位置，决定拷贝的顺序
第二轮，基本就是BQ，各种项目问题，给了一个SQL的题，以及一个machine learning和bussiness decision的问题，这一轮感觉最懵逼
第三轮， 跟老大吃饭聊天，老大是东欧的某个国家，记不清楚是哪个，反正巨喜欢足球，网球。说中国队的球踢的太烂他们业余队都能对付男足 哎。这一轮的题目是两个linked list代表的numbers,做加法，实在是不能再简单了。
第四轮， 国人老哥过来面，问了一道LeetCode medium的原题，用2pointers就很容易解，然后问了下后台backend如果说某个用户抱怨说request请求时长大幅增长10倍，可能是啥情况。最后问了下LRU的实现原理。这一轮也直接秒掉
第五轮， 硬度三哥，一上来自我介绍，说是从aws过来的，多么多么的牛逼，然后就问了两个bq的问题，比方说很多任务要做，如何安排自己的priority。