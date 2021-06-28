### NoJumpBreakCrops

This is a very simple Minecraft plugin who prevent unpermitted players 
to break crops by jumping on them. This plugin **does not** have any other purpose !

It should work with Bukkit, Spigot and Paper in **1.16+**.

*I made this plugin for a private server and I decided to share 
it because maybe some people will find it useful. 
I may or **may not** add some features.*

*The code could be better organized but I think it's fine for what it does.*


#### Commands

- `/njbcset <true | false>` : activate or deactivate the anti-jumbreak-crops system.

#### Permissions

By default all op players can break crops by jumping on them.

- `njbc.breakcrops` : if a player has this permission
  set to **true** he will be able to break crops by jumping on them. 
  If this permission is explicitly defined to **false** for a player *(even Operators)*
  he'll not be able to breakcrops by jumping on them.
  
- `njbc.admin.njbcset` : permission to use the */njbcset* command.

#### Config File

Pretty simple, it only contains the boolean wich defines if the plugin is enabled.