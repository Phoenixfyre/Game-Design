# Game-Design


https://www.spriters-resource.com/game_boy_gbc/thelegendofzeldaoracleofseasons/sheet/8930/

Collision Detection
if(pressedKeys.contains(e.VK_RIGHT)){
			mario.setPosition(mario.getPosition()[0]+speed, mario.getPosition()[1]);
			mario.setAnimation("Run", 0, 1);
			mario.setanimationSpeed(100);
			mario.start();
			mario.setLooping(true);
			if(mario.collidesWith(platform)){
				mario.setPosition(mario.getPosition()[0]-speed, mario.getPosition()[1]);
			}
		}
		if(pressedKeys.contains(e.VK_UP)){
			mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]-speed);
			if(mario.collidesWith(platform)){
				mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]+speed);
			}
		}
		if(pressedKeys.contains(e.VK_LEFT)){
			mario.setPosition(mario.getPosition()[0]-speed, mario.getPosition()[1]);
			if(mario.collidesWith(platform)){
				mario.setPosition(mario.getPosition()[0]+speed, mario.getPosition()[1]);
			}
		}
		if(pressedKeys.contains(e.VK_DOWN)){
			mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]+speed);
			if(mario.collidesWith(platform)){
				mario.setPosition(mario.getPosition()[0], mario.getPosition()[1]-speed);
			}
		}
