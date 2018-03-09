# Spatial Quickstart

## Prerequisites:
  
  * [Java 8](https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-get-on-ubuntu-16-04)
  * [SBT](https://www.scala-sbt.org/1.0/docs/Setup.html)

## To setup:
  
```bash
git clone https://github.com/stanford-ppl/spatial-quickstart.git
export SPATIAL_HOME=`pwd`/spatial-quickstart
```


## To run:

```bash
sbt "runMain <name of app> <compile flags>"
cd <generated directory>
make <target>
bash run.sh <arguments>
```

## Links:

  * [Source Code](https://github.com/stanford-ppl/spatial-lang)
  * [Website](https://spatial.stanford.edu)
  * [Documentation](http://spatial-lang.readthedocs.io/en/latest/)
  * [Forum](https://groups.google.com/forum/#!forum/spatial-lang-users)
