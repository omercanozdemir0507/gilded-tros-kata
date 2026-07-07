Refactored using the Strategy Pattern. 
Each item behavior is encapsulated in its own ItemUpdater implementation, selected via ItemUpdaterFactory. 
This makes adding new item categories (like smelly items) possible without modifying existing code (Open/Closed Principle).