# Spatial Quickstart

## Prerequisites:
  
  * [Java 8](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04)
  * [SBT](https://www.scala-sbt.org/1.0/docs/Setup.html)

## To setup:

Spatial-quickstart provides the scala project skeleton and a build.sbt configured to fetch Spatial from the Nexus Repository Manager without requiring a local installation or build of the compiler.  If you prefer the full language and compiler, visit the [Spatial repo](https://github.com/stanford-ppl/spatial)

Please follow these instructions to install spatial-quickstart:
  
```bash
git clone https://github.com/stanford-ppl/spatial-quickstart.git
export SPATIAL_HOME=`pwd`/spatial-quickstart
```


## To run:

```bash
bin/spatial <name of app> <compile flags>
cd <generated directory>
make <target>
bash run.sh <arguments>
```

## Links:

  * [Source Code](https://github.com/stanford-ppl/spatial-lang)
  * [Website](https://spatial.stanford.edu)
  * [Documentation](http://spatial-lang.readthedocs.io/en/latest/)
  * [Forum](https://groups.google.com/forum/#!forum/spatial-lang-users)
