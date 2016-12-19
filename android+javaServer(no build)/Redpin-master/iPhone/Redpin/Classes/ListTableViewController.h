//
//  ListViewController.h
//  Redpin
/**  This file is part of the Redpin project.
 * 
 *  Redpin is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published
 *  by the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  Redpin is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with Redpin. If not, see <http://www.gnu.org/licenses/>.
 *
 * © Copyright ETH Zurich, Pascal Brogle, Philipp Bolliger, 2010, ALL RIGHTS RESERVED.
 * 
 *  www.redpin.org
 */


#import <UIKit/UIKit.h>
#import "MapListTableViewController.h"
#import "LocationListTableViewController.h"

@interface ListTableViewController : UITableViewController {
	NSMutableArray *list;
	MapListTableViewController *mapListController;
	LocationListTableViewController *locationListController;
}

@property (nonatomic, readonly) NSMutableArray *list;
@property (nonatomic, retain) MapListTableViewController *mapListController;
@property (nonatomic, retain) LocationListTableViewController *locationListController;

- (void) initMapListController;	
- (void) initLocationListController;

@end