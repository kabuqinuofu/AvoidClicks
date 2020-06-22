# AvoidClicks

> 使用AOP的方式实现防止按钮多次点击。

使用方法很简单，需要几步配置，配置完成之后直接添加注解即可使用，下面是配置方法：

## 引入

1. 在项目的`build.gradle`中的`buildscript`中的`dependencies`添加：

```
dependencies {
    ...
    classpath 'com.hujiang.aspectjx:gradle-android-plugin-aspectjx:2.0.10'
}
```

2. 在项目的`build.gradle`中的`allprojects`中的`repositories`添加：

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

3. 在`app`的`build.gradle`中的最上面添加

```
apply plugin: 'android-aspectjx'
```

4. 在`app`的`build.gradle`中的`dependencies`添加

```
implementation 'com.github.kabuqinuofu:AvoidClicks:V1.0.2'
```

## 使用方法

直接在按钮的点击事件上面添加注解即可使用。

在`Java`中：

```
@ControlClick
@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.clickId:
            Log.e("TAG","***");
        break;
    }
}
```

在`Kotlin`中：

```
@ControlClick
override fun onClick(v: View?) {
    if (v != null) {
        when(v.id){
            R.id.clickId ->{
            Log.e("TAG","***");
            }
        }
    }
}
```

默认间隔时间为`1000`毫秒，可以自行修改，在注解后面添加括号，在括号中输入需要的时间值即可。

```
@ControlClick(500)
override fun onClick(v: View?) {
    if (v != null) {
        when(v.id){
            R.id.btnClick ->{
            Log.e("TAG","***");
            }
        }
    }
}
```
