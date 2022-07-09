# BugsSmpPlugin
## Features:
> /gmc, /gma, /gms, /gmt   - commands for easy gamemode switching

> (In Progress) /ping command to get player ping/

> (In Progress) /playerinfo <player>  - Get info about a player, online or not. Shows position, dimension, ping, uuid, ip

> /invsee, /endersee  - To view and edit players inventory or enderchest, works on both online or offline players
 
> Simple log, easier to read and understand log for player chat, commands, join, leave, etc

 
 config.yml:
```yml
 # Bugs SMP Plugin Config

# Enable or Disable Features
commands:
  # Set gamemode survival command
  gms: true
  # Set gamemode adventure command
  gma: true
  # Set gamemode creative command
  gmc: true
  # Set gamemode spectator command
  gmt: true
  # Player info command
  player-info: true
  # Ping command
  ping: true
  # invsee and endersee command
  invsee: true

# Enable or Disable storing certain information
log-data:
  # Log IP
  log-address: true
  # Log logout location
  log-logout-location: true

# Enable or Disable log files
logging:
  # Enable simple log file
  simple-log: true
 ```
