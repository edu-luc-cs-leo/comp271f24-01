////public String toString() {
////    StringBuilder result = new StringBuilder();
////    if (this.head == null) {
////        return "NO STATIONS FOUND";
////    }
////
////    TrainStation cursor = this.head;
////    boolean leftToRight = true; // If left to right, line number is odd
////    StringBuilder line = new StringBuilder();
////    int lineLength = 0;
////    int numLines = 0;
////    // Print first station
////    result.append(cursor.getName());
////    cursor = cursor.getNext();
////
////    // iterate through all stations
////    if (cursor != null) {
////        if (leftToRight) {
////            // Runs while adding a new string (including transition) does not throw length over 80
////            while (lineLength + rPlus.length() < LINELENGTH) {
////                if (numLines > 1) {
////                    if (lineLength == 0) {
////                        line.append(rPArrow);
////                    } else {
////                        line.append(rArrow);
////                    } // lineLength != 0
////                } // numLines > 1
////                line.append(cursor.getName()); // add string
////                lineLength = line.length();   // update lineLength to reflect added
////                cursor = cursor.getNext();   // shift cursor up one element
////            }                               // after this we have a full line
////
////            if (numLines > 0) {
////                result.append(line).append("\n").append(bar);
////
////            } else {
////                result.append(line);
////            } // First Line
////            numLines += 1;
////        } else {
////
////        }
////
////
////    }
////
////    result.append("null");
////    return result.toString();
////}
//
//public void insert(String name, int position) {
//    // Create a new station to insert
//    TrainStation newStation = new TrainStation(name);
//
//    // Check if the position is valid
//    if (position < 1 || position > numberOfStations) {
//        throw new IndexOutOfBoundsException("Position out of bounds");
//    }
//
//    // If inserting at the head (position 1)
//    if (position == 1) {
//        newStation.setNext(this.head); // Link new station to current head
//        this.head = newStation; // Update head to new station
//        if (this.tail == null) { // If the line was empty, set tail to new station
//            this.tail = newStation;
//        }
//    } else {
//        // Navigate to the station before the specified position
//        TrainStation cursor = this.head;
//        for (int i = 1; i < position - 1; i++) {
//            cursor = cursor.getNext(); // Move to the station at position - 1
//        }
//
//        // Insert the new station after the cursor
//        newStation.setNext(cursor.getNext()); // Link new station to the next station
//        cursor.setNext(newStation); // Link the previous station to the new station
//
//        // If we are inserting at the end, update the tail
//        if (newStation.getNext() == null) {
//            this.tail = newStation;
//        }
//    }
//
//    // Increment the number of stations
//    this.numberOfStations++;
//}
