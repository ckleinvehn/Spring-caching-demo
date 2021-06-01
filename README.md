Single GET endpoint (/fibonacci/{n}) which computes fib(n) recursively. 


# [No caching](https://github.com/ckleinvehn/Spring-caching-demo/releases/tag/fibonacci-no-caching)
Before caching was implemented. Naive. Repeated, wasted computation.


# [Local caching](https://github.com/ckleinvehn/Spring-caching-demo/releases/tag/fibonacci-local-caching)
An in-memory data store. Improved performance.


# [Local caching in non-prod, AWS ElastiCache in prod](https://github.com/ckleinvehn/Spring-caching-demo/releases/tag/fibonacci-AWS-ElastiCache)
An in-memory data store when non-prod (e.g., local development and testing), otherwise an AWS ElastiCache config for Redis in prod.
