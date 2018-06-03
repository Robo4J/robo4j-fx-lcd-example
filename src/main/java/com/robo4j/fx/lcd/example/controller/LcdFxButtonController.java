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

package com.robo4j.fx.lcd.example.controller;

import com.robo4j.RoboContext;
import com.robo4j.fx.lcd.example.LcdFxController;
import com.robo4j.socket.http.units.ExtendedRoboUnit;
import com.robo4j.units.rpi.lcd.AdafruitButtonEnum;

/**
 * @author Marcus Hirt (@hirt)
 * @author Miro Wengner (@miragemiko)
 */
public class LcdFxButtonController extends ExtendedRoboUnit<AdafruitButtonEnum, LcdFxController> {
    
    public LcdFxButtonController(RoboContext context, String id) {
        super(AdafruitButtonEnum.class, context, id);
    }

    @Override
    public void onMessage(AdafruitButtonEnum message) {

        switch (message) {
            case UP:
                getService().up();
                break;
            case DOWN:
                getService().down();
                break;
            case LEFT:
                getService().left();
                break;
            case RIGHT:
                getService().right();
                break;
            case SELECT:
                getService().select();
                break;
        }
    }
}
