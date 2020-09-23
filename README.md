# GroupItemDecoration
Android 自定义ItemDecoration-实现分组吸顶效果
**[Android 自定义ItemDecoration-实现分组吸顶效果](https://www.jianshu.com/p/eaabde1880db)**
- 使用自定义ItemDecoration 来实现RecyclerView的分组头，还有吸顶的效果

 ![itemDecoration.gif](https://upload-images.jianshu.io/upload_images/1627327-8a3e8c475d8f53a5.gif?imageMogr2/auto-orient/strip)


### 1.了解 RecyclerView.ItemDecoration
#### 1.onDraw方法
- 我们看源码的注释，看看onDraw方法做什么
![onDraw.png](https://upload-images.jianshu.io/upload_images/1627327-917e1d08e909fe34.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

 - 看不懂没关系，翻译上，大概意思就是这个方法绘制的东西，会在RecyclerView绘制之前绘制，所以会被压在下面
![翻译.png](https://upload-images.jianshu.io/upload_images/1627327-a6640b3085a0e1f4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


#### 2.onDrawOver方法
- onDrawOver跟onDraw刚好相反，他是在RecyclerView绘制之后绘制，会盖在RecyclerView上面
![onDrawOver.png](https://upload-images.jianshu.io/upload_images/1627327-26c4748581d53b42.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![翻译.png](https://upload-images.jianshu.io/upload_images/1627327-8be45db449640141.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


#### 3.getItemOffsets方法
- getItemOffsets方法，主要就是给itemView设置偏移量，比如RecyclerView的设置LinearLayoutManger,使用Vertical垂直方向，那上下item之间的分隔线的空间，就可以在这设置，
- outRect.set(0, 5, 0, 0)，就代表top方向偏移5像素点，然后就预留出了5像素点高度的空间，给你绘制分隔线，而不会影响itemView
- 看注释，设置偏移量要在后面，就是super要么不写，要么写在前面，看源码super把全部设置为0
- 注释也告诉你，RecyclerView#getChildAdapterPosition(View)可以通过view获取position
- 查看源码，RecyclerView的LayoutParams，是有viewHolder的，所以可以通过View 获取LayoutParams,再拿到ViewHolder
![getItemOffsets](https://upload-images.jianshu.io/upload_images/1627327-e3bdd9a35b2830e8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/1627327-61db1bd67f884456.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
![image.png](https://upload-images.jianshu.io/upload_images/1627327-d4b42839f3aa9762.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
