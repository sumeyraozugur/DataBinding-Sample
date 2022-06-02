# DataBinding-Sample

## :loudspeaker: Kotlin Synthetics

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



## :loudspeaker:FindViewByID
For using FindViewById you don't need to add anything in gradle file.  You can also use it in Java.

### :round_pushpin:In Activity

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

### :round_pushpin: In Fragment

```Kotlin
    private lateinit var  buton: Button
    private lateinit var  textName: TextView
    private lateinit var  textPopulation: TextView
    private lateinit var  textFamous: TextView

```

```Kotlin
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city = City("İzmir",3000,"Boyoz")
        buton = view.findViewById(R.id.btnClick)
        textName = view.findViewById(R.id.textView)
        textPopulation = view.findViewById(R.id.textView3)
        textFamous = view.findViewById(R.id.textView2)


        textName.text = city.name
        textPopulation.text=city.population.toString()
        textFamous.text= city.famousWith

        buton.setOnClickListener {
            Toast.makeText(activity,"Button Cliked",Toast.LENGTH_SHORT).show()

        }

```

## :loudspeaker: DataBinding

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

### :round_pushpin:In Activity 
You should initialize it first ```private lateinit var binding: ActivityMainBinding ```

```Kotlin
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    binding.city =City("İzmir",300,"Boyoz")


```

###  :round_pushpin:In Fragment

```Kotlin
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

```

```Kotlin

 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.city =City("İzmir",300,"Boyoz")
        binding.btnClick.setOnClickListener {
            Toast.makeText(activity, "Button cliked",Toast.LENGTH_SHORT).show()
        }
    }

```


## :loudspeaker:ViewBinding

### :round_pushpin: In Activity
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

 ### :round_pushpin: In Fragment
 
 ```Kotlin
    private var _binding: FragmentBlankBinding? = null
    private val binding get() = _binding!!

 
 ```
 
 
 ```Kotlin
     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?,
     ): View? {
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
        
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val city =City("İzmir",3000,"Boyoz")
        binding.textView.text = city.name
        binding.textView2.text = city.population.toString()
        binding.textView3.text = city.famousWith

        binding.btnClick.setOnClickListener {
            Toast.makeText(activity, "Button cliked", Toast.LENGTH_SHORT).show()
        }


 
 ```
 
 
In Google I/O'19, Google said us you should [viewBinding](https://developer.android.com/topic/libraries/view-binding). If you want to watch it. Please [click](https://www.youtube.com/watch?v=Qxj2eBmXLHg&t=446s)
 <img src="https://user-images.githubusercontent.com/41166029/171000852-18e981da-edd1-4207-9ee0-1043d1be2115.png" width="450"/>
 
 
 
 
In below, you will see my viewBinding screenshot. I did it every part(findViewById, viewBinding, dataBinding). If you examine this codes. You will get it better. 

 <img src="https://user-images.githubusercontent.com/41166029/170981243-4a0a0288-7ac0-4f5d-ad98-0d35245a7014.png" width="200" hspace="5"/>



  
  

  
  
