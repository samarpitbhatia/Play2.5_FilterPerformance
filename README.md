# Play 2.5 Filter performance downgrade

This is the example project for reproducing play 2.5 filter performance downgrade

### Running

Sbt comes prepackaged with the project, just download the project and run the following:-

```
sbt stage
cd target/universal/stage
bin/play-rest-api -Dplay.crypto.secret=testing
```

### Problem

Run the service in production mode as described above. Load test /status API with ab (apache benchmark) with Filters enabled/disabled.
Filters can be enabled/disabled in application.conf just comment the filter configuration to disable it.

Performance:-

Filters Disabled: 58K req/sec

Filters Enabled:  42K req/sec

Load testing command: ab -n 10000000 -c 50 -k http://localhost:9000/status

### Logs

#### Filters disabled

MacBook-Pro-2:Play2.5_FilterPerformance v643887$ ab -n 10000000 -c 50 -s 100 -k http://localhost:9000/status
This is ApacheBench, Version 2.3 <$Revision: 1706008 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 1000000 requests
Completed 2000000 requests
Completed 3000000 requests
Completed 4000000 requests
Completed 5000000 requests
Completed 6000000 requests
Completed 7000000 requests
Completed 8000000 requests
Completed 9000000 requests
Completed 10000000 requests
Finished 10000000 requests


Server Software:
Server Hostname:        localhost
Server Port:            9000

Document Path:          /status
Document Length:        0 bytes

Concurrency Level:      50
Time taken for tests:   165.759 seconds
Complete requests:      10000000
Failed requests:        0
Keep-Alive requests:    10000000
Total transferred:      990000000 bytes
HTML transferred:       0 bytes
Requests per second:    60328.43 [#/sec] (mean)
Time per request:       0.829 [ms] (mean)
Time per request:       0.017 [ms] (mean, across all concurrent requests)
Transfer rate:          5832.53 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       2
Processing:     0    1   0.3      1      50
Waiting:        0    1   0.3      1      50
Total:          0    1   0.3      1      50

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      1
  80%      1
  90%      1
  95%      1
  98%      2
  99%      2
 100%     50 (longest request)

#### Filters Enabled

MacBook-Pro-2:Play2.5_FilterPerformance v643887$ ab -n 10000000 -c 50 -s 100 -k http://localhost:9000/status
This is ApacheBench, Version 2.3 <$Revision: 1706008 $>
Copyright 1996 Adam Twiss, Zeus Technology Ltd, http://www.zeustech.net/
Licensed to The Apache Software Foundation, http://www.apache.org/

Benchmarking localhost (be patient)
Completed 1000000 requests
Completed 2000000 requests
Completed 3000000 requests
Completed 4000000 requests
Completed 5000000 requests
Completed 6000000 requests
Completed 7000000 requests
Completed 8000000 requests
Completed 9000000 requests
Completed 10000000 requests
Finished 10000000 requests


Server Software:
Server Hostname:        localhost
Server Port:            9000

Document Path:          /status
Document Length:        0 bytes

Concurrency Level:      50
Time taken for tests:   245.892 seconds
Complete requests:      10000000
Failed requests:        0
Keep-Alive requests:    10000000
Total transferred:      990000000 bytes
HTML transferred:       0 bytes
Requests per second:    40668.33 [#/sec] (mean)
Time per request:       1.229 [ms] (mean)
Time per request:       0.025 [ms] (mean, across all concurrent requests)
Transfer rate:          3931.80 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.0      0       3
Processing:     0    1   0.6      1     110
Waiting:        0    1   0.6      1     110
Total:          0    1   0.6      1     110

Percentage of the requests served within a certain time (ms)
  50%      1
  66%      1
  75%      1
  80%      2
  90%      2
  95%      2
  98%      3
  99%      3
 100%    110 (longest request)


