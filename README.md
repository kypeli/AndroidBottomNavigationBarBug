## Android BottomNavigationView bug
This is a sample application demonstrating the bug in Android BottomNavigationView in the case when you have three to five items in the menu and programatically select one of the pages. **There is no animation in the bottom navigation bar when the page changes.**

From the animation below you can see that the page switch animation works fine when tapping on the bottom navigation items. But when I press the "Next" and "Prev" buttons to programatically switch the page, there's no animation. 

![gif](https://raw.githubusercontent.com/kypeli/AndroidBottomNavigationBarBug/master/BottomNavigationBarBug.gif "")

### Dependencies 
```
compile 'com.android.support:appcompat-v7:25.2.0'
compile 'com.android.support.constraint:constraint-layout:1.0.0'
compile 'com.android.support:design:25.2.0'
```
  