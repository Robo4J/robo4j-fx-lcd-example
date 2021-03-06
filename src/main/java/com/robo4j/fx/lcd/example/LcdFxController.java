/*
 * Copyright (c) 2014, 2017, Marcus Hirt, Miroslav Wengner
 *
 * Robo4J is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Robo4J is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Robo4J. If not, see <http://www.gnu.org/licenses/>.
 */

package com.robo4j.fx.lcd.example;

import com.robo4j.RoboContext;
import com.robo4j.fx.lcd.example.demo.FxColorDemo;
import com.robo4j.fx.lcd.example.demo.FxDisplayDemo;
import com.robo4j.fx.lcd.example.demo.FxExitDemo;
import com.robo4j.fx.lcd.example.demo.FxLcdDemo;
import com.robo4j.fx.lcd.example.demo.FxNotImplementedDemo;
import com.robo4j.fx.lcd.example.demo.FxScrollDemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * JavaFx Application controller
 *
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
public class LcdFxController {

	public static final String DEFAULT_TEXT = "Robo4J: Welcome!\nPress up/down...";
	private RoboContext system;
	private int currentScroll = -1;
	private FxLcdDemo[] FX_DEMOS = new FxLcdDemo[] { new FxScrollDemo(), new FxColorDemo(), new FxDisplayDemo(), new FxExitDemo()};
	private AtomicBoolean active = new AtomicBoolean(false);

	@FXML
	private TextArea lcdTA;

	public void init(RoboContext system) {
		this.system = system;
	}

	@FXML
	private void selectButtonAction(ActionEvent event) {
		select();
	}

	@FXML
	private void leftButtonAction(ActionEvent event){
		left();
	}

	@FXML
	private void upButtonAction(ActionEvent event){
		up();

	}

	@FXML
	private void rightButtonAction(ActionEvent event){
		right();
	}

	@FXML
	private void downButtonAction(ActionEvent event){
		down();
	}

	@FXML
	public void initialize() {
		lcdTA.setText(DEFAULT_TEXT);
	}

	public void select(){
		if(active.compareAndSet(false, true)){
			FxLcdDemo demo = FX_DEMOS[currentScroll];
			demo.initiate(active, lcdTA);
			system.getScheduler().execute(demo.getTask());
		}
	}

	public void down(){
		currentScroll++;
		displayActiveDemo();
	}

	public void up(){
		currentScroll--;
		displayActiveDemo();
	}

	public void right(){
		notImplementedMessage();
	}

	public void left(){
		notImplementedMessage();
	}

	//Private Methods
	private void displayActiveDemo(){
		if(!active.get()){
			if(currentScroll <= 0 ){
				currentScroll = 0;
			} else if(currentScroll >= FX_DEMOS.length){
				currentScroll = FX_DEMOS.length - 1;
			}
			lcdTA.setText(currentScroll + "#" + FX_DEMOS[currentScroll].getName() + "\nPress Select!");
		}
	}

	private void notImplementedMessage(){
		if(active.compareAndSet(false, true)){
			FxNotImplementedDemo demo = new FxNotImplementedDemo();
			demo.initiate(active, lcdTA);
			system.getScheduler().execute(demo.getTask());
			currentScroll = 0;
		}
	}
}
