
				// PUT IN if(pressedkeys.contains(KeyEvent_VK_F) or whatever

				if(mario.collidesWith(rock1)){
					
					rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY()-10);
					y2=1;
					rock1.setVelY(0);
				}
				
				if(mario.collidesWith(rock3)&& rock3.isVisible()){
					rock3.setPosition(mario.getPosition().getX()+5,mario.getPosition().getY()-10);
					y3=1;
					rock3.setVelY(0);
				}
				
				// PUT IN if(!pressedkeys.contains(KeyEvent_VK_F) or whatever

				if(y2==1){
					rock1.setPosition(mario.getPosition().getX(), mario.getPosition().getY());
					y2=0;
					rock1.setVelY(5);
					}
					
					if(y3==1){
						rock3.setPosition(mario.getPosition().getX(), mario.getPosition().getY()+10);
						y3=0;
						rock3.setVelY(5);
					}
					
					
					
					
				//put wherever

					if(rock1.collidesWith(platform1)){
						rock1.setVelY(0);
					}
					if(rock1.collidesWith(platform2)){
						rock1.setVelY(5);
					}
					if(rock1.collidesWith(platform3)){
						rock1.setVelY(0);
					}
					if(rock1.collidesWith(platform4)){
						rock1.setVelY(0);
					}
					if(rock1.getPosition().getY()>1200){
						rock1.setPosition(platform1.getPosition().getX()+20,platform1.getPosition().getY()-50);
					}
					if(rock3.getPosition().getY()>1300){
						rock3.setPosition(10950,180);
					}
					
					rock1.updatePhys();
					rock3.updatePhys();
					
					if(rock3.collidesWith(platform29)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(platform30)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(movplat1)){
						rock3.setVelY(5);
					}
					if(rock3.collidesWith(movplat2)){
						rock3.setVelY(5);
					}
					if(rock3.collidesWith(movplat3)){
						rock3.setVelY(5);
					}
					if(rock3.collidesWith(movplat4)){
						rock3.setVelY(5);
					}
					if(rock3.collidesWith(platform18)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(platform22)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(platform27)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(platform29)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(pressure2)){
						rock3.setVelY(0);
					}
					if(rock3.collidesWith(platform28)){
						rock3.setVelY(0);
					}
