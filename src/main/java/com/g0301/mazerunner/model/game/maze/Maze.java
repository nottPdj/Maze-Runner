package com.g0301.mazerunner.model.game.maze;

import com.g0301.mazerunner.model.game.camera.MazeCamera;
import com.g0301.mazerunner.model.game.MazePosition;
import com.g0301.mazerunner.model.game.elements.*;

import java.util.List;

public class Maze {
    private final int width;
    private final int height;
    private Player player;
    private List<Monster> monsters;
    private List<Wall> walls;
    private List<Wall> nightWalls;
    private List<Ground> grounds;
    private Map scoutedMap;
    private MazeCamera camera;
    private boolean night;
    public Maze(int width, int height){
        this.width=width;
        this.height=height;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public MazeCamera getCamera() {
        return camera;
    }
    public void setCamera(MazeCamera camera) {this.camera = camera;}
    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player=player;
        setCamera(new MazeCamera(player));
        player.add(camera);
    }
    public List<Monster> getMonsters(){
        return monsters;
    }
    public void setMonsters(List<Monster> monsters){
        this.monsters=monsters;
    }
    public List<Wall> getWalls(){
        return walls;
    }
    public void setWalls(List<Wall> walls){
        this.walls=walls;
    }
    public List<Wall> getNightWalls(){
        return nightWalls;
    }
    public void setNightWalls(List<Wall> walls){
        this.nightWalls=walls;
    }
    public List<Ground> getGrounds() {
        return grounds;
    }
    public void setGrounds(List<Ground> grounds) {
        this.grounds = grounds;
    }
    public void setMap(Map map) {
        scoutedMap = map;
        scoutedMap.setGrounds(grounds);
        scoutedMap.setPlayer(player);
    }
    public boolean isMonster(MazePosition position){
        for (Monster monster:monsters){
            if(monster.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public Map getScoutedMap() {
        return scoutedMap;
    }
    public void setScoutedMap(Map map) {
        this.scoutedMap = map;
    }
    public boolean isEmpty(MazePosition position){
        for(Wall wall:walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }
    public boolean outsideMap() {
        return (player.getPosition().getX() < 0 || player.getPosition().getX() >= getWidth()
                || player.getPosition().getY() < 0 || player.getPosition().getY() >= getHeight());
    }
    public boolean isNight(){
        return night;
    }
    public void setNight(boolean n){
        updateWalls(n);
        checkPlayerPosition();
        this.night=n;
    }

    private void updateWalls(boolean n) {
        if (n) {
            for (Wall wall : nightWalls) {
                walls.add(wall);
            }
        } else {
            for (Wall wall : nightWalls) {
                walls.remove(wall);
            }
        }
    }

    private void checkPlayerPosition() {
        if (!isEmpty(player.getPosition())) {
            player.setDead(true);
        }
    }
}

