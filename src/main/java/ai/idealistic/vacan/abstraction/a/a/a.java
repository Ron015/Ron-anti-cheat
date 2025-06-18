package ai.idealistic.vacan.abstraction.a.a;

public class a extends ai.idealistic.vacan.abstraction.a.a {
   public a() {
      super("messages");
   }

   public void ay() {
      this.b("console_name", "Console");
      this.b("no_permission", "&8[&2{prefix}&8]&c You don't have permission to interact with this.");
      this.b("player_not_found_message", "&8[&2{prefix}&8]&c Player not found.");
      this.b("config_reload", "&8[&2{prefix}&8]&e Config successfully reloaded.");
      this.b("panic_mode_enable", "&8[&2{prefix}&8]&a Panic mode enabled, all checks are set to silent and will not punish players.");
      this.b("panic_mode_disable", "&8[&2{prefix}&8]&c Panic mode disabled, all checks will now run per configuration standards.");
      this.b("kick_reason", "&c {reason}");
      this.b("kick_broadcast_message", "&8[&2{prefix}&8]&c {player}&7 was kicked for&4 {reason}");
      this.b("player_ip_limit_kick_message", "&8[&2{prefix}&8]&c The player limit of your IP has been reached.");
      this.b("player_violation_reset_message", "&8[&2{prefix}&8]&a Violations successfully reset for player&8: &2{player}");
      this.b("player_stored_data_delete_message", "&8[&2{prefix}&8]&a Stored data successfully deleted for player&8: &2{player}");
      this.b("detection_notification", "&8[&2{prefix}&8] &e{player} &7>> &c{detection:real}§8[{detection:level}§8] &7(§f{info}§7)");
      this.b("check_stored_data_delete_message", "&8[&2{prefix}&8]&a Stored data successfully deleted for check&8: &2{check}");
      this.b("check_enable_message", "&8[&2{prefix}&8] &aYou enabled the check&8:&7 {detection}");
      this.b("check_disable_message", "&8[&2{prefix}&8] &cYou disabled the check&8:&7 {detection}");
      this.b("check_silent_disable_message", "&8[&2{prefix}&8] &aYou enabled preventions for the check&8:&7 {detection}");
      this.b("check_silent_enable_message", "&8[&2{prefix}&8] &cYou disabled preventions for the check&8:&7 {detection}");
      this.b("check_punishment_enable_message", "&8[&2{prefix}&8] &aYou enabled punishments for the check&8:&7 {detection}");
      this.b("check_punishment_disable_message", "&8[&2{prefix}&8] &cYou disabled punishments for the check&8:&7 {detection}");
      this.b("non_existing_check", "&8[&2{prefix}&8] &cThis check doesn't exist.");
      this.b("bypass_message", "&8[&2{prefix}&8] &c{player} &7is now bypassing the &4{detection} &7check for &e{time} &7seconds.");
      this.b("warning_message", "&c {reason}");
      this.b("warning_feedback_message", "&8[&2{prefix}&8]&7 You warned &c{player} &7for&8: &4{reason}");
      this.b("verbose_enable", "&8[&2{prefix}&8] &aYou enabled verbose.");
      this.b("verbose_disable", "&8[&2{prefix}&8] &cYou disabled verbose.");
      this.b("notifications_enable", "&8[&2{prefix}&8] &aYou enabled notifications.");
      this.b("notifications_modified", "&8[&2{prefix}&8] &eYou modified notifications.");
      this.b("notifications_disable", "&8[&2{prefix}&8] &cYou disabled notifications.");
      this.b("awareness_notification", "&8[&2{prefix} Notification&8]&a {info}");
      this.b("wave_start_message", "&8[&2{prefix}&8]&c The wave is starting.");
      this.b("wave_end_message", "&8[&2{prefix}&8]&c The wave has ended with a total of {total} action(s).");
      this.b("wave_clear_message", "&8[&2{prefix}&8]&c The wave was cleared.");
      this.b("wave_add_message", "&8[&2{prefix}&8]&a {player} was added to the wave.");
      this.b("wave_remove_message", "&8[&2{prefix}&8]&c {player} was removed from the wave.");
      this.b("full_wave_list", "&8[&2{prefix}&8]&c The wave list is full.");
      this.b("wave_not_added_message", "&8[&2{prefix}&8]&c {player} is not added to the wave.");
      this.b("unknown_command", "&fUnknown command. Please type \"/help\" for help.");
      this.b("failed_command", "&8[&2{prefix}&8]&c Command failed ({command}). Please check your arguments and try again.");
      this.b("successful_command", "&8[&2{prefix}&8]&a Command successful.");
      this.b("massive_command_reason", "&8[&2{prefix}&8]&c The length of the reason is too big.");
   }
}
