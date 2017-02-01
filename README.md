# Play 2.5 Filter performance downgrade

This is the example project for reproducing play 2.5 filter performance downgrade

### Running

Sbt comes prepackaged with the project, just download the project and enter following at the command prompt will start up Play in development mode:

```
sbt run
```

You can also create a distribution package using:-

```
sbt dist
```

or start Play in production mode, by [staging the application](https://www.playframework.com/documentation/2.5.x/Deploying) and running the play script:s

```
sbt stage
cd target/universal/stage
bin/play-rest-api -Dplay.crypto.secret=testing
```

### Problem

I created a distribution package and uploaded it to AWS EC2 c3.xlarge machine.

Load test /status API with and without Filters enabled. Filters can be enabled/disabled in application.conf just comment the filter configuration to disable it.

Performance:-

Filters Disabled: 34K req/sec

Filters Enabled:  19K req/sec

FYI: JMeter was used to load test from an external machine on AWS EC2.