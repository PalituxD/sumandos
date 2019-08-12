
#!/bin/bash

export ENV_DATABASE_SERVER="database"
export ENV_DATABASE_PORT="3306"
export ENV_DATABASE_PORTS="3306:3006"
export ENV_DATABASE_DATABASE="testdb"
export ENV_DATABASE_APPLICATION_USER="user"
export ENV_DATABASE_APPLICATION_PASSWORD="password"
export ENV_DATABASE_ROOT_USER="root"
export ENV_DATABASE_ROOT_PASSWORD="root"

export ENV_APPLICATION_SERVER="calculator"
export ENV_APPLICATION_PORT="8090"
export ENV_APPLICATION_PORTS="8090:8090"

export ENV_COLLECTOR_SERVER="prometheus"
export ENV_COLLECTOR_PORT="8090"
export ENV_COLLECTOR_PORTS="9090:9090"

export ENV_MONITOR_SERVER="grafana"
export ENV_MONITOR_PORT="3000"
export ENV_MONITOR_PORTS="3000:3000"