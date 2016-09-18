import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Gets a certain location, and checks whether two locations are equal or not
 * 
 * Location Class
 * 
 * @author David Collins
 */
public class Location
    {
        private int row;
        private int col;
        public Location(int x, int y)
        {
            row = x;
            col = y;
        }
        /**
         * Returns the row/X part of the location
         */
        public int getRow()
        {
            return row;
        }
        /**
         * Returns the column/Y part of the location
         */
        public int getCol()
        {
            return col;
        }
        /**
         * Checks if two locations are equal, taken from location class in Gridworld
         */
        public boolean equals(Object other)
        {
            if (!(other instanceof Location))
                return false;

            Location otherLoc = (Location) other;
            return getRow() == otherLoc.getRow() && getCol() == otherLoc.getCol();
        }
        /**
         * What is outputted when you print a location object, taken from Gridworld location class
         */
        public String toString()
        {
        return "(" + getRow() + ", " + getCol() + ")";
        }
    }
