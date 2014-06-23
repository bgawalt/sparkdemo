# SparkDemo

I'd love to assemble this project into a single jar, but I'm having trouble with the
dependency graph:

```
oDesks-MacBook-Air-9:sparkdemo bgawalt$ sbt/sbt assembly
[info] Loading project definition from /Users/bgawalt/sparkdemo/project
[info] Set current project to sparkdemo (in build file:/Users/bgawalt/sparkdemo/)
[info] Including from cache: jetty-http-8.1.14.v20131031.jar
[info] Including from cache: commons-beanutils-core-1.8.0.jar
    [SNIP]
[info] Including from cache: jets3t-0.7.1.jar
[info] Including from cache: commons-httpclient-3.1.jar
[info] Checking every *.class/*.jar file's SHA-1.
[info] Merging files...
[warn] Merging 'META-INF/DEPENDENCIES' with strategy 'discard'
[warn] Merging 'META-INF/ECLIPSEF.RSA' with strategy 'first'
[warn] Merging 'META-INF/ECLIPSEF.SF' with strategy 'discard'
[warn] Merging 'META-INF/INDEX.LIST' with strategy 'discard'
[warn] Merging 'META-INF/MANIFEST.MF' with strategy 'discard'
[warn] Merging 'META-INF/mailcap' with strategy 'first'
java.lang.RuntimeException: deduplicate: different file contents found in the following:
/Users/bgawalt/.ivy2/cache/com.esotericsoftware.kryo/kryo/bundles/kryo-2.21.jar:com/esotericsoftware/minlog/Log$Logger.class
/Users/bgawalt/.ivy2/cache/com.esotericsoftware.minlog/minlog/jars/minlog-1.2.jar:com/esotericsoftware/minlog/Log$Logger.class
	at sbtassembly.Plugin$Assembly$.sbtassembly$Plugin$Assembly$$applyStrategy$1(Plugin.scala:253)
	at sbtassembly.Plugin$Assembly$$anonfun$15.apply(Plugin.scala:270)
	[SNIP]
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:744)
[error] (*:assembly) deduplicate: different file contents found in the following:
[error] /Users/bgawalt/.ivy2/cache/com.esotericsoftware.kryo/kryo/bundles/kryo-2.21.jar:com/esotericsoftware/minlog/Log$Logger.class
[error] /Users/bgawalt/.ivy2/cache/com.esotericsoftware.minlog/minlog/jars/minlog-1.2.jar:com/esotericsoftware/minlog/Log$Logger.class
[error] Total time: 13 s, completed Jun 23, 2014 1:15:46 PM
```

I've tried blindly adding MergeStrategies, but had no luck so far.

