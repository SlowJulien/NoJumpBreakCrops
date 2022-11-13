### NoJumpBreakCrops

This is a very simple Minecraft plugin which prevent unauthorized players
to break crops by jumping on them. This plugin **does not** have any other purpose !

It should work with Bukkit, Spigot and Paper in **1.16+**.

*I made this plugin for a private server and I decided to share
it because maybe some people will find it useful.
I may or **may not** add some features.*

*The code could be better organized, but I think it's fine for what it does.*

[Spigot Ressource Link](https://www.spigotmc.org/resources/nojumpbreakcrops.93706/)

#### Usage Infos
If you just want to install this plugin to prevent any non-op player from breaking crops
by jumping on them simply put the plugin in the plugins folder. That's all.

If you also want operators to be affected by the plugin set the *affectop* properties to true.

You can go further by using the permissions mentioned below.

#### Commands

- `/njbc` : show the plugin configuration.
- `/njbc <enable | disable>` : enable or disable the plugin.
- `/njbc affectop <true | false>` : if set to true default operators
  will be affected by the plugin if they do not have the permission
  `njbc.breakcrops` explicitly set to true.


#### Permissions

By default, all op players can break crops by jumping on them.

- `njbc.breakcrops` : if a player has this permission
  set to **true** he will be able to break crops by jumping on them.
  If this permission is explicitly set to **false** for a player *(even Operators)*
  he'll not be able to break crops by jumping on them. False by default for everyone
  but operators bypass it if *affectop* is set to false.

- `njbc.admin` : permission to use the */njbc* command. False by default
  for non-op players.

#### Config File

- `affectop` (boolean) : true if operators are affected by the plugin.
- `enabled` (boolean) : true if the plugin is enabled.