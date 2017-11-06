# Android developent with Kotlin
A simple Android application developed using `Kotlin` language instead of `Java`. App also uses `RecyclerView`, `CardView` and `Picasso` image downloading library. 

![demo-video](demo.gif)

## Goal

Goal of this project was to try all the basic stuff in Kotlin from primitives, ranges, collections, control flows, loops to object declarations, object expressions, singletons, companion objects, type projections, lambdas etc. Final goal was to actually use Kotlin in Android and see how everything plays out. From my epxerience, I can tell you that I had a positive first impression.

One important thing (for learners, not for experts I guess) to note in code (`ImageDownloaderSingleton.kt, ImageDownloader.kt, PicassoImageDownloader.kt`) is how I download images. I have tried to decouple image downloading library _Picasso_ from my code so that it is easy to switch between different image downloading libraries just by changing a single line of code. The task becomes even more easy if we use a dependency injection library like `Dagger 2.0`. 
