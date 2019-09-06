第一轮：问我分布式文件存储系统，一个很大的文件的存取流程是什么。我对这方面不太了解，扯了一点皮毛之后扯不下去了，直接跟面‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌试官说我不太懂呀

Done:
The Maze: 做到 the maze III, 但是前两问不熟
面试官说好吧那我来考你别的吧，于是问了我一道算法题：在棋盘上给一个起点一个终点，判断国际象棋里面的Knight（类似中国象棋里的马）是否能够从起点移到终点。我用的BFS, 但是貌似有更简单的方法。


中午陪经理吃饭，一个半小时，聊得还算愉快
第二轮：问了一些项目里的问题，接下来问我一个full stack的系统如何Debug，讨论了很多细节。。。然后又让我设计一个点歌系统，顾客可以花钱在一个屏幕上点歌。之中问到了哪些歌应该放在前面，我说可以用LRU cache, 于是又让我讲了讲实现，感觉自己讲得不是很清楚。
第三轮：三道常见算法题，没什么好说的，就是有点累：刷题网 酒吧，衣伞巴，伞似漆。
第四轮：问了问behavior, 然后是刷题网 似衣漆, 用的BFS。

done:98
done:138

done:347
done:147

417

LC 126. Word Ladder II, BFS imp, then discuss how to bu‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌ild the graph,
LC 45. Jump Game II
done LC 56. Merge Intervals

Design Email service and client. 
You drive the conversation and discuss features like how to send ad emails to millions of users. write an email at app and then loss internet connetion. attachment. browse emails with page. edit email in multiple clients and delta update

Design git to support git push, and later search key words and display urls to the files that have the key words.



Cultrure fit discussion. 

Many of them are from Amazon, so they also have the leadership questions like how do you handle disagreement with coworkers/managers, how do you handle when you miss a deadline. describe a case where you need cooperate with multiple teams to deliver something. When you need make an important decision and why you make such a choice, what is the alternatives, pros cons etc. 


1. 给出一个<电影明星，电影作品>的字典和任意两个明星，找出他们之间的关系路径。例：约翰有作品1,2,3，汤姆有作品3,4, 山姆有作品4,5。求汤姆和山姆的路径，是约翰->3-‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌>汤姆->4->山姆.

2. 给出两个链表节点和一个链表，调换这两个节点。

$. 午饭轮，聊聊工作问题。

3. 基本计算器。只有乘和加。再聊聊工作问题。

4. 抬杠者 (意译)，聊聊工作问题。一个小系统设计，两个异地的数据中心，同时是读写库，怎么去同步数据。


我只到了电面：
1. 问一个SQL，具体有两个TABLE，然后求出 每个DEPARTEMENT 的 平均工资‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌是多少， 要 GROUP BY 和 JOIN 一下
2. 问到了 储存 密码，用STRING好 还是用 CHAR [] 好，并说出理由（网上有答案）
3. 脑经急转弯， 有三个人在一个屋子里，每一个人知道自己的工资，但不知道别人的工资，怎么样才能知道三人的平均工资？ 每一个人都不能直接问别人工资是多少
4. 窨井盖为什么是圆的
觉得甲骨文的题好有趣，也不容易准备， 然后我就挂了

再发一个我朋友的，电面面到了 2PC
ONSITE 面到了 利口 四
然后 问你 一个DB TABLE 里面有一个 COLUMN 存了性别，问你在这个 COLUMN上加 INDEX 有用吗


自己海投第二天收到的recruiter邮件。面的是OCI在Seattle Downtown。

第一面： recruiter
自我介绍和经历以及确定组
第二面：senior manager
他自嗨了10分钟。安排电面
第三面：电面 印度人。说话听不清。。。大多数时间都是在确认他在说啥
done: leetcode 154 稍微改一下。inital array是一个sorted的array，问你shift了多少次才会变成现在的array。做法一摸一样。就是把return的值变成index而已。面完马上给onsite。

onsite:
1. 问了简历。给一个binary tree和target number。return treenode的位置。具体位置可以自己定义。比如按preorder定义，从index0开始标记每个node的位置。


2. lunch interview。和senior manager吃饭两天。我有一年工作经验但是senior还差得很远。很诧异为什么给我面试。。
具体的问题有：1. 和manager有分歧怎么办。2. comment teammate的时候有disagree怎么办。3. 最自豪的一件事。然后深扣细节。
3. 给一个int 2d array表示一个地图。每个点的值表示相对高度。要求从左上角走到右下角。且只能改变一次上下的方向。即，一开始往上走，然后可以有一次机会往下走。如果是平地就不算是改变方向。面试一开始就和我说，他要重点考察我test和另外一个什么能力（忘了，bq相关的）。我和他解释我的思路的时候他会听，但是我转过去写白板的时候他就会开始玩手机。code里面的corner case想了一段时间。给了大概10几分钟。code没有写完打断我问了很多关于test方面的问题。问的大多数问题我都不知道他在问什么。。必挂的一轮


4. 给一个BST和一个target number，可以保证tree里有这个node。要求返回这个number的successor。一开始给了个O(n)的in order traverse的解。然后用stack记录parent找target node给了时间log(n)空间log(n)的解。要求优化空间，去掉stack，用一个variable记录往左子树走的parent，时间O(height), 空间O(1)。follow up是，如果target可能不存在。但是要是要返回比target number大的最小值。用一个variable记录遍历过的点如果比target大就更新。最后return这个点。


5. 两个bar raiser轮番轰炸。1. 收到过哪些negative的feedback。2. 说一下自己miss deadline的事情。3. 和同事有conflict的时候怎么办。还有一些一下子想不起来了。

来onsite之前，就看到一些消息说只要2年工作经验以上的SDE。当然就在想为什么我能拿到onsite。中午和senior manager面试的时候感觉他不怎么热情，不怎么想聊天。问了他一句你们接下来的招人计划，回我说要招senior。可以说很不给我面子。很尴尬了。


总体的面试感觉是，算法题都不难。senior manager给我一种不怎么想面我的感觉。这个体验非常差。
MOVE ON了！



补充内容 (2019-7-27 14:26):
第二点说的话不通，有很多语病。。我想说的是，和senior manager吃饭聊天。senior manager说要招senior sde。但是我只有一年经验。我很诧异怎么就给我安排了面试。



店面：
‍‍‍‍‍‌‍‍‌‍‌‌‌‌‌‌2‌      忘记了，不是常规题，需求很长，然后算法简单。最后加问了下Java多线程的问题，AtomicInteger之类。

Onsite：
     OCI很注重Culture fit，所以onsite之前，一定要把Recruiter发的OCI的Value好好看看，然后结合下自己的工作经历。
     第一轮：
             BQ + 算法。算法是Leetcode 1091， 我其实并没有做得很好，我觉得最重要是交流，并不会要求Code无bug啥的。
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

DP done: maximal square 利口儿儿要，

DP done: coin change II 利口五一吧。
都是dp