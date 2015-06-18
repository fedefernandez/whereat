import android.Dependencies.aar
import android.Keys.{
  platformTarget,
  Android,
  proguardScala,
  useProguard,
  proguardOptions,
  apkbuildExcludes,
  dexMaxHeap,
  proguardCache,
  ProguardCache}

//MACROID STUFF//

android.Plugin.androidBuild

platformTarget in Android := "android-21"

name := "whereat"

// Application Version
version := "1.0.0"

scalaVersion := "2.11.6"

resolvers ++= Seq(
  Resolver.mavenLocal,
  DefaultMavenRepository,
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.typesafeIvyRepo("snapshots"),
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.defaultLocal,
  "47deg Public" at "http://clinker.47deg.com/nexus/content/groups/public",
  "jcenter" at "http://jcenter.bintray.com",
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
)

run <<= run in Android

// Activate proguard for Scala
proguardScala in Android := true

// Activate proguard for Android
useProguard in Android := true

// Set proguard options
proguardOptions in Android ++= Seq(
  "-ignorewarnings",
  "-keep class scala.Dynamic"
)

dexMaxHeap in Android := "2048m"

libraryDependencies ++= Seq(
  aar("org.macroid" %% "macroid" % "2.0.0-M4"),
  aar("org.macroid" %% "macroid-viewable" % "2.0.0-M4"),
  aar("com.android.support" % "support-v4" % "22.1.1"),
  aar("com.fortysevendeg" %% "macroid-extras" % "0.1-SNAPSHOT"),
  "com.google.android.gms" % "play-services" % "6.5.87",
  "io.taig" %% "communicator" % "2.0.1",
  "com.typesafe.play" %% "play-json" % "2.3.4",
  "org.specs2" %% "specs2-core" % "3.6-scalaz-7.0.7" % "test",
  "org.specs2" %% "specs2-mock" % "3.6-scalaz-7.0.7" % "test",
  "org.specs2" %% "specs2-junit" % "3.6-scalaz-7.0.7" % "test",
//  "org.specs2" %% "specs2-core" % "2.4.15" % "test",
//  "org.specs2" %% "specs2-mock" % "3.0-M2" % "test",
  "com.google.android" % "android" % "4.1.1.4" % "test",
  compilerPlugin("org.brianmckenna" %% "wartremover" % "0.10")
)


proguardCache in Android ++= Seq(
//  ProguardCache("macroid") % "org.macroid" % "macroid_2.11",
//  ProguardCache("macroid-viewable") % "org.macroid" % "macroid-viewable_2.11",
//  ProguardCache("support-v4") % "com.android.support" % "support-v4",
//  ProguardCache("macroid-extras") % "com.fortysevendeg" % "macroid-extras_2.11",
  ProguardCache("com.google") % "com.google.android.gms" % "play-services",
  ProguardCache("io.taig.communicator") % "io.taig" % "communicator_2.11",
  ProguardCache("play.api.libs.json") % "com.typesafe.play"  % "play-json_2.11",
  ProguardCache("play.api.libs.functional") % "com.typesafe.play" % "play-functional_2.11"
)

apkbuildExcludes in Android ++= Seq (
  "META-INF/LICENSE",
  "META-INF/LICENSE.txt",
  "META-INF/NOTICE",
  "META-INF/NOTICE.txt"
)
