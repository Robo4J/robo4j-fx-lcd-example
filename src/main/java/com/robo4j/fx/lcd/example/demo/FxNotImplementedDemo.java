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

package com.robo4j.fx.lcd.example.demo;

import com.robo4j.fx.lcd.example.LcdFxController;
import javafx.concurrent.Task;
import javafx.scene.control.TextArea;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
public class FxNotImplementedDemo implements FxLcdDemo {
	private static final int DELAY = 500;
	private static final String[] COLORS = new String[] { "red", "snow" };
	private static final String text = "Not Available," + LcdFxController.DEFAULT_TEXT;
	private final String name = "NotAvailable";
	private TextArea textArea;
	private Task<Void> task;
	private AtomicBoolean active;

	@Override
	public void initiate(AtomicBoolean active, TextArea textArea) {
		this.active = active;
		this.textArea = textArea;
		String[] messages = text.split(",");
		task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				textArea.setStyle(FxDemoUtil.getCssBackground(COLORS[0]));
				updateMessage(messages[0]);
				TimeUnit.MILLISECONDS.sleep(DELAY);
				updateMessage(messages[1]);
				textArea.setStyle(FxDemoUtil.getCssBackground(COLORS[1]));
				TimeUnit.MILLISECONDS.sleep(DELAY);
				textArea.textProperty().unbind();
				active.set(false);
				return null;
			}
		};
		textArea.textProperty().bind(task.messageProperty());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Task<Void> getTask() {
		return task;
	}
}
