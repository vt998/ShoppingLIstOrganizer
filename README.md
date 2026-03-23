Android app built with Jetpack Compose

Features
Add, view, and check off shopping items
Data persists between app launches (Room DB)
Syncs with remote server 

Stack
Kotlin · Jetpack Compose · Room · ViewModel · Coroutines · Retrofit · Material 3

Custom Addition
Inline add-item input embedded directly in the list (AddItemButton inside LazyColumn)
Migrated annotation processing from kapt to ksp — the modern replacement recommended for new projects

Challenges
Passing Application context to ViewModel → used AndroidViewModel + custom factory
DB calls on background thread → Dispatchers.IO


