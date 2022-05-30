# DataBinding-Sample

## Kotlin Synthetics

```
plugins{

id 'kotlin-android-extensions'

}

```

You should add this in build.gradle and then you can use [kotlin-synthetic](https://android-developers.googleblog.com/2022/02/discontinuing-kotlin-synthetics-for-views.html)
````
textView.text = "Sumeyra"
````
**Dipnot:** [kotlin synthetic](https://android-developers.googleblog.com/2020/11/the-future-of-kotlin-android-extensions.html) will be removed in Kotlin 1.8, which is expected to be released by the end of 2022.  



## FindViewByID
For using FindViewById you don't need to add anything in gradle file.  You can also use it in Java.

````Kotlin
        val textName:TextView = findViewById(R.id.textView)
        val textPopulation:TextView = findViewById(R.id.textView2)
        val textFamous:TextView = findViewById(R.id.textView3)
        val buttonClick: Button = findViewById(R.id.btnClick )

        val izmir = City("İzmir",3000,"Boyoz")

        textName.text = izmir.name
        textPopulation.text = "Nüfusu: ${izmir.population}"
        textFamous.text =izmir.famousWith

        buttonClick.setOnClickListener {
            Toast.makeText(applicationContext,"Button Cliked",Toast.LENGTH_SHORT).show()
        }

````

## DataBinding

For [dataBinding](https://developer.android.com/jetpack/androidx/releases/databinding), you should add this and ``kotlin-kapt`` plugin in build.gradle 
````
buildFeatures {
        dataBinding true
    }
````

if you want to use dataBinding, you have to open layout tag in xml.

````Kotlin
<layout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

````

if you want to use data directly in xml, databinding make you use that like this

````
 <data>
        <variable
            name="city"
            type="com.sum.databinding.City"
            />

    </data>
````


In TextView  you should do like this  ``` android:text="@{city.name}" ``` 

In MainActiviy 
You should initialize it first ```private lateinit var binding: ActivityMainBinding ```

```Kotlin

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.city =City("İzmir",300,"Boyoz")


```


## ViewBinding

````
buildFeatures {
        viewBinding true
    }
````
You should this part in build.gradle and then you can use it everywhere. Of Course you should initialize it first. 
```private lateinit var binding: ActivityMainBinding ```

```Kotlin
  binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val izmir = City("İzmir",3000,"Boyoz")

        binding.textView.text = izmir.name
        binding.textView2.text =izmir.population.toString()
        binding.textView3.text = izmir.famousWith

```
In Google I/O'19, Google said us you should [viewBinding](https://developer.android.com/topic/libraries/view-binding). If you want to watch it. Please [click](https://www.youtube.com/watch?v=Qxj2eBmXLHg&t=446s)
 <img src="https://user-images.githubusercontent.com/41166029/171000852-18e981da-edd1-4207-9ee0-1043d1be2115.png" width="450"/>
 
 
In below, you will see my screenshots. If you examine this codes. You will get it better. 


<div>
<table>
  <tr>
    <td >FindViewById </td>
     <td >DataBinding</td>
    <td >ViewBinding</td>
  
 
  </tr>
  
  <tr>
    <td >
      <img src="https://user-images.githubusercontent.com/41166029/170981265-8dc1a849-62d1-479a-8387-a0a3ab60101c.png" width="200" hspace="5"/>
    </td>
   <td>
     <img src="https://user-images.githubusercontent.com/41166029/170981849-3fe5d38c-c13d-47f6-8c1c-5b6559df78d0.png" width="200" hspace="5"/>
    </td>
       <td>
     <img src="https://user-images.githubusercontent.com/41166029/170981243-4a0a0288-7ac0-4f5d-ad98-0d35245a7014.png" width="200" hspace="5"/>
    </td>

        
  </tr>
 </table>
  </div> 
  
  

  
  
