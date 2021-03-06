package net.mintar.proxy.Listeners;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.mintar.proxy.MainClass;
import net.mintar.proxy.utils.Ranks;
import net.mintar.proxy.utils.RanksManager;

public class UtilListeners implements Listener {

    @EventHandler
    public void onJoin(ServerConnectedEvent e){
        RanksManager.getRank(e.getPlayer());
        e.getPlayer().setTabHeader(new TextComponent("§3§lMINTAR§b§lGAMES.\n§c§lBETA! §8§l(Report bugs on the forums!)§r"), new TextComponent("§7Visit §b§lwww.mintar.net §7to see our store, forums and more!§r"));
        if(!MainClass.staffListVanish.contains(e.getPlayer())){
            if(RanksManager.getRank(e.getPlayer()) == Ranks.FOUNDER){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Owners.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.MANAGER){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Managers.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.DEVELOPER){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Developers.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.ADMIN){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Administrators.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.MODERATOR){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Moderators.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.TRIAL){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has joined the server!"));
                MainClass.Trainees.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.WELL_KNOWN){
                MainClass.VIP.add(e.getPlayer());
            }else if(RanksManager.getRank(e.getPlayer()) == Ranks.PARTNER) {
                MainClass.Partner.add(e.getPlayer());
            }
        }

        e.getPlayer().sendMessage(new TextComponent("§3Welcome, §b§l" + e.getPlayer().getDisplayName() + "§3 to §3§lMintar§b§lGames!"));
    }

    @EventHandler
    public void onLeave(ServerDisconnectEvent e){
        if(!MainClass.staffListVanish.contains(e.getPlayer())){
            if(MainClass.Owners.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Owners.remove(e.getPlayer());
            }else if(MainClass.Managers.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Managers.remove(e.getPlayer());
            }else if(MainClass.Administrators.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Administrators.remove(e.getPlayer());
            }else if(MainClass.Developers.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Developers.remove(e.getPlayer());
            }else if(MainClass.Moderators.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Moderators.remove(e.getPlayer());
            }else if(MainClass.Trainees.contains(e.getPlayer())){
                ProxyServer.getInstance().broadcast(new TextComponent("§3§lProxy §8» " + e.getPlayer().getDisplayName() + " §7has left the server!"));
                MainClass.Trainees.remove(e.getPlayer());
            }else if(MainClass.VIP.contains(e.getPlayer())){
                MainClass.VIP.remove(e.getPlayer());
            }else if(MainClass.Partner.contains(e.getPlayer())){
                MainClass.Partner.remove(e.getPlayer());
            }
        }
    }

    @EventHandler
    public void onPing(ProxyPingEvent e){
        e.getResponse().setDescriptionComponent(new TextComponent("§c    §3         §b§m---§8§m[§3§m-§r §3§lMintar§b§lGames §71.7-1.12 §3§m-§8§m]§b§m---§r\n    §3          §b§lALPHA v2 §8§m--§r §3§l75% Sale §b§lNOW ON!"));
    }

}
