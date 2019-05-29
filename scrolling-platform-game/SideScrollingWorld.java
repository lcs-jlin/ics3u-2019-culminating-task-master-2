
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Template for a side-scrolling platform game.
 * 
 * @author R. Gordon
 * @version May 8, 2019
 */
public class SideScrollingWorld extends World
{
    /**
     * Instance variables
     * 
     * These are available for use in any method below.
     */    
    // Tile size in pixels for world elements (blocks, clouds, etc)
    // TO STUDENTS: Modify if your game's tiles have different dimensions
    private static final int TILE_SIZE = 32;
    private static final int HALF_TILE_SIZE = TILE_SIZE / 2;

    // World size constants
    // TO STUDENTS: Modify only if you're sure
    //              Should be a resolution that's a multiple of TILE_SIZE
    private static final int VISIBLE_WIDTH = 640;
    private static final int VISIBLE_HEIGHT = 480;

    // Additional useful constants based on world size
    public static final int HALF_VISIBLE_WIDTH = VISIBLE_WIDTH / 2;
    private static final int HALF_VISIBLE_HEIGHT = VISIBLE_HEIGHT / 2;

    // Defining the boundaries of the scrollable world
    // TO STUDENTS: Modify SCROLLABLE_WIDTH if you wish to have a longer level
    public static final int SCROLLABLE_WIDTH = VISIBLE_WIDTH * 3;
    private static final int SCROLLABLE_HEIGHT = VISIBLE_HEIGHT;

    // Hero
    Mario theMario;

    // Track whether game is on
    private boolean isGameOver;

    // Timing
    private boolean time;
    
    /**
     * Constructor for objects of class SideScrollingWorld.
     */
    public SideScrollingWorld()
    {    
        // Create a new world with 640x480 cells with a cell size of 1x1 pixels.
        // Final argument of 'false' means that actors in the world are not restricted to the world boundary.
        // See: https://www.greenfoot.org/files/javadoc/greenfoot/World.html#World-int-int-int-boolean-
        super(VISIBLE_WIDTH, VISIBLE_HEIGHT, 1, false);

        // Set up the starting scene
        setup();

        // Game on
        isGameOver = false;
    }

    /**
     * Set up the entire world.
     */
    private void setup()
    {
        // TO STUDENTS: Add, revise, or remove methods as needed to define your own game's world
        addLeftGround();
        addFences();
        addCactus();
        //addMetalPlateSteps();
        addClouds();
        addRightGround();
        addHero();
    }

    /**
     * Add blocks to create the ground to walk on at bottom-left of scrollable world.
     */
    private void addLeftGround()
    {
        // How many tiles will cover the bottom of the initial visible area of screen?
        final int tilesToCreate = getWidth() / TILE_SIZE;

        // Loop to create and add the tile objects
        for (int i = 0; i < 10; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 12; i < 14; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 16; i < 33; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 35; i < 36; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 37; i < 38; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 39; i < 40; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
        for (int i = 41; i < 60; i += 1)
        {
            // Add ground objects at bottom of screen
            // NOTE: Actors are added based on their centrepoint, so the math is a bit trickier.
            int x = i * TILE_SIZE + HALF_TILE_SIZE;
            int y = getHeight() - HALF_TILE_SIZE;

            // Create a ground tile
            Ground groundTile = new Ground(x, y);

            // Add the objects
            addObject(groundTile, x, y);
        }
    }

    /**
     * Add some fences at left and right side.
     */
    private void addFences()
    {
        // Three fences on left side of world
        int x = HALF_TILE_SIZE + TILE_SIZE * 2;
        int y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fence fence1 = new Fence(x, y);
        addObject(fence1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 3;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;        
        Fence fence2 = new Fence(x, y);
        addObject(fence2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 4;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fence fence3 = new Fence(x, y);
        addObject(fence3, x, y);

        // Two fences on right side of world
        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 1;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 13;
        Fence fence4 = new Fence(x, y);
        addObject(fence4, x, y);

        x = SCROLLABLE_WIDTH - HALF_TILE_SIZE - TILE_SIZE * 2;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 13;
        Fence fence5 = new Fence(x, y);
        addObject(fence5, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 24;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate1 = new MetalPlate(x, y);
        addObject(metalplate1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 25;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate2 = new MetalPlate(x, y);
        addObject(metalplate2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 26;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate3 = new MetalPlate(x, y);
        addObject(metalplate3, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 27;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate4 = new MetalPlate(x, y);
        addObject(metalplate4, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 28;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate5 = new MetalPlate(x, y);
        addObject(metalplate5, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 29;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate6 = new MetalPlate(x, y);
        addObject(metalplate6, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 30;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate7 = new MetalPlate(x, y);
        addObject(metalplate7, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 42;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate8 = new MetalPlate(x, y);
        addObject(metalplate8, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 43;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate9 = new MetalPlate(x, y);
        addObject(metalplate9, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 44;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate10 = new MetalPlate(x, y);
        addObject(metalplate10, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 45;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate11 = new MetalPlate(x, y);
        addObject(metalplate11, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 48;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 6;
        MetalPlate metalplate12 = new MetalPlate(x, y);
        addObject(metalplate12, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 46;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate13 = new MetalPlate(x, y);
        addObject(metalplate13, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 49;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 6;
        MetalPlate metalplate14 = new MetalPlate(x, y);
        addObject(metalplate14, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 50;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 6;
        MetalPlate metalplate15 = new MetalPlate(x, y);
        addObject(metalplate15, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 52;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 9;
        MetalPlate metalplate16 = new MetalPlate(x, y);
        addObject(metalplate16, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 53;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 9;
        MetalPlate metalplate17 = new MetalPlate(x, y);
        addObject(metalplate17, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 54;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 9;
        MetalPlate metalplate18 = new MetalPlate(x, y);
        addObject(metalplate18, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 56;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 12;
        MetalPlate metalplate19 = new MetalPlate(x, y);
        addObject(metalplate19, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 57;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 12;
        MetalPlate metalplate20 = new MetalPlate(x, y);
        addObject(metalplate20, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 58;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 12;
        MetalPlate metalplate21 = new MetalPlate(x, y);
        addObject(metalplate21, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 12;
        MetalPlate metalplate22 = new MetalPlate(x, y);
        addObject(metalplate22, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 46;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 2;
        MetalPlate metalplate23 = new MetalPlate(x, y);
        addObject(metalplate23, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 46;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 1;
        MetalPlate metalplate24 = new MetalPlate(x, y);
        addObject(metalplate24, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 11;
        MetalPlate metalplate25 = new MetalPlate(x, y);
        addObject(metalplate25, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 10;
        MetalPlate metalplate26 = new MetalPlate(x, y);
        addObject(metalplate26, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 9;
        MetalPlate metalplate27 = new MetalPlate(x, y);
        addObject(metalplate27, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 8;
        MetalPlate metalplate28 = new MetalPlate(x, y);
        addObject(metalplate28, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 7;
        MetalPlate metalplate29 = new MetalPlate(x, y);
        addObject(metalplate29, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 6;
        MetalPlate metalplate30 = new MetalPlate(x, y);
        addObject(metalplate30, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 5;
        MetalPlate metalplate31 = new MetalPlate(x, y);
        addObject(metalplate31, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 4;
        MetalPlate metalplate32 = new MetalPlate(x, y);
        addObject(metalplate32, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 3;
        MetalPlate metalplate33 = new MetalPlate(x, y);
        addObject(metalplate33, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 2;
        MetalPlate metalplate34 = new MetalPlate(x, y);
        addObject(metalplate34, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 59;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 1;
        MetalPlate metalplate35 = new MetalPlate(x, y);
        addObject(metalplate35, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 39;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 7;
        MetalPlate metalplate36 = new MetalPlate(x, y);
        addObject(metalplate36, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 45;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 10;
        MetalPlate metalplate37 = new MetalPlate(x, y);
        addObject(metalplate37, x, y);

    }

    /**
     * Add cactus.
     */
    private void addCactus()
    {

        int x = HALF_TILE_SIZE + TILE_SIZE * 7;
        int y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus1 = new Cactus1(x, y);
        addObject(cactus1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 19;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus cactus2 = new Cactus(x, y);
        addObject(cactus2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 24;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus3 = new Cactus1(x, y);
        addObject(cactus3, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 25;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus4 = new Cactus1(x, y);
        addObject(cactus4, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 26;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus5 = new Cactus1(x, y);
        addObject(cactus5, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 27;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus6 = new Cactus1(x, y);
        addObject(cactus6, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 28;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus7 = new Cactus1(x, y);
        addObject(cactus7, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 29;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus8 = new Cactus1(x, y);
        addObject(cactus8, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 30;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Cactus1 cactus9 = new Cactus1(x, y);
        addObject(cactus9, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 26;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 4;
        Cactus cactus10 = new Cactus(x, y);
        addObject(cactus10, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 29;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 4;
        Cactus1 cactus11 = new Cactus1(x, y);
        addObject(cactus11, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 20;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Bird bird1 = new Bird(x, y);
        addObject(bird1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 35;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Bird bird2 = new Bird(x, y);
        addObject(bird2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 60;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Bird bird3 = new Bird(x, y);
        addObject(bird3, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 57;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fakebird fakebird = new Fakebird(x, y);
        addObject(fakebird, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 50;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE;
        Fakebird fakebird1 = new Fakebird(x, y);
        addObject(fakebird1, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 44;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 4;
        Cactus1 cactus12 = new Cactus1(x, y);
        addObject(cactus12, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 52;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 7;
        Fakebird fakebird2 = new Fakebird(x, y);
        addObject(fakebird2, x, y);

        x = HALF_TILE_SIZE + TILE_SIZE * 57;
        y = VISIBLE_HEIGHT - HALF_TILE_SIZE - TILE_SIZE * 10;
        Fakebird fakebird3 = new Fakebird(x, y);
        addObject(fakebird3, x, y);
    }

    /**
     * Add a few clouds for the opening scene.
     */
    private void addClouds()
    {
        Cloud cloud1 = new Cloud(170, 125);
        addObject(cloud1, 170, 125);
        Cloud cloud2 = new Cloud(450, 175);
        addObject(cloud2, 450, 175);
        Cloud cloud3 = new Cloud(775, 50);
        addObject(cloud3, 775, 50);
    }


    /**
     * Add the hero to the world.
     */
    private void addHero()
    {
        // Initial horizontal position
        int initialX = TILE_SIZE * 3;

        // Instantiate the hero object
        theMario = new Mario(initialX);

        // Add hero in bottom left corner of screen
        addObject(theMario, initialX, getHeight() / 4 * 3);
    }

    /**
     * Add blocks to create the ground to walk on at top-right of scrollable world.
     */
    private void addRightGround()
    {
        // Constants to control dimensions of the ground at end of world
        final int COUNT_OF_GROUND = 8;
        final int GROUND_BELOW_COLUMNS = COUNT_OF_GROUND;
        final int GROUND_BELOW_ROWS = 6;
        final int COUNT_OF_GROUND_BELOW = GROUND_BELOW_COLUMNS * GROUND_BELOW_ROWS;

        // 1. Make ground at end of level (top layer)

        // 2. Make sub-ground at end of level (below top layer)
    }

    /**
     * Return an object reference to the hero.
     */
    public Mario getMario()
    {
        return theMario;
    }

    /**
     * Add the time to the world.
     */
    private void countTime()
    {

    }

    /**
     * Set game over
     */
    public void setGameOver()
    {
        isGameOver = true;

    }

}

