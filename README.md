# project-setup
Basic Android project setup example ready with mocks

Project has 2 flavors: `prod` and `mock`. Depending on selected flavor:

- `prod` will fetch data from server
- `mock` will return data from local json file
- `androidTest` are setup to use `mock` as source

The change of source if accomplished by using different `Application` class and using different Dagger component which can then inject real or mock classes.

Used in project: Dagger2, Arch components, Retrofit, Coroutines
