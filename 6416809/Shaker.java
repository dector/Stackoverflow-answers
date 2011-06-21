/**
 * Copyright (c) 2011, dector (dector9@gmail.com) All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 *  - Neither the name of the nor the names of its
 * contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

//package ua.org.dector.stackoverflow;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Shaker {
	public static List<String> shake(List<String> sourceList) {
		Random random = new Random();

		// We'll use cloned original list
		List<String> itemsList = new ArrayList<String>(sourceList);

		// Count how much items need shaking
		int itemsToMerge = itemsList.size();
	
		// New generated list
		List<String> newList = new ArrayList<String>();

		// Temporary values, used in cycle
		String insertValue;
		int selectedItemIndex;
		int currentItemIndex;

		while (0 < itemsToMerge) {
			// Select random value from source list
			selectedItemIndex = random.nextInt(itemsToMerge);
			insertValue = itemsList.remove(selectedItemIndex);

			// Select random mergin position
			currentItemIndex = random.nextInt(itemsToMerge + 1);
			
			// IF random position in new list is empty
			if (newList.size() - 1 < currentItemIndex) {
				//   THEN just add item
				newList.add(insertValue);
			} else {
				//   ELSE merge new item to existing value
				newList.add(currentItemIndex, newList.remove(currentItemIndex) + insertValue);
			}

			itemsToMerge--;
		}

		return newList;
	}
}