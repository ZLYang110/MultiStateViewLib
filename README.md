# MultiStateView

视图加载状态

视图加载状态,加载中,加载成功,加载失败,空数据等页面,支持自定义页面

[GitHub主页](https://github.com/ZLYang110/MultiStateViewLib)

[简书](https://www.jianshu.com/p/8c7b2ebd892a)




# 运行截图
<img src="https://github.com/ZLYang110/MultiStateViewLib/raw/master/screenshot/Screenshot_20200507_135535_com.zlyandroid.multist.jpg" width = "180" height = "300" alt="图片名称"/> <img src="https://github.com/ZLYang110/MultiStateViewLib/raw/master/screenshot/Screenshot_20200507_135542_com.zlyandroid.multist.jpg" width = "180" height = "300" alt="图片名称" /> <img src="https://github.com/ZLYang110/MultiStateViewLib/raw/master/screenshot/Screenshot_20200507_135551_com.zlyandroid.multist.jpg" width = "180" height = "300" alt="图片名称"/> <img src="https://github.com/ZLYang110/MultiStateViewLib/raw/master/screenshot/Screenshot_20200507_135627_com.zlyandroid.multist.jpg" width = "180" height = "300" alt=" "  />

# 使用说明

## 集成


- ### 添加jitpack库

```java
// build.gradle(Project:)
allprojects {
    repositories {
        ...
            maven { url 'https://www.jitpack.io' }
    }
}
```

- ### 添加依赖

```groovy
// build.gradle(Module:)
dependencies {

   implementation 'com.github.ZLYang110:MultiStateViewLib:1.0'
}
```

 ```java

        <com.zlylib.multistateview.MultiStateView
              android:id="@+id/multiStateView"
              style="@style/MultiStateStyle"
              android:layout_width="match_parent"
              android:layout_height="match_parent">

              <ListView
                  android:id="@+id/list"
                  android:layout_width="match_parent"
                  android:layout_height="match_parent"
                  tools:listitem="@android:layout/simple_list_item_1" />
          </com.zlylib.multistateview.MultiStateView>

 ```


```java

           case R.id.error:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
                return true;

            case R.id.empty:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                return true;

            case R.id.content:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                return true;

            case R.id.loading:
                startLoading(mMultiStateView);
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);

```
