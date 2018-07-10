# Game-Design


https://www.spriters-resource.com/game_boy_gbc/thelegendofzeldaoracleofseasons/sheet/8930/

Collision

if(pressedKeys.contains(e.VK_UP)){
			mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]-speed);
			if(mario.collidesWith(platform)){
				mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]+speed);
			}
		}
