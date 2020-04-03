//
//  ViewController.swift
//  UI_Performance_ios
//
//  Created by NazarKo on 4/3/20.
//  Copyright © 2020 NazarKo. All rights reserved.
//

import UIKit

class TableViewController: UITableViewController {

    var items = Item.createItems()
    let identifier: String = "tableCell"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        setupUI()
        // Do any additional setup after loading the view.
    }
}

extension TableViewController {

    func setupUI() {
        navigationItem.backBarButtonItem = UIBarButtonItem(title: "", style: .done, target: self, action: nil)
        tableView.reloadData()
    }

}

// MARK: - UITableView DataSource

extension TableViewController {

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return items.count
    }
    
    

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell = tableView.dequeueReusableCell(withIdentifier: identifier) as? TableCell {
            let screenSize = UIScreen.main.bounds
            let separatorHeight = CGFloat(20.0)
            let additionalSeparator1 = UIView.init(frame: CGRect(x: 0, y: 20-separatorHeight, width: screenSize.width, height: separatorHeight))
            additionalSeparator1.backgroundColor = UIColor.white
            
            cell.addSubview(additionalSeparator1)
            
            cell.configurateTheCell(items[indexPath.row])
            let additionalSeparator2 = UIView.init(frame: CGRect(x: 0, y: 140-separatorHeight, width: screenSize.width, height: separatorHeight))
            additionalSeparator2.backgroundColor = UIColor.white
            cell.addSubview(additionalSeparator2)
            return cell
        }
        return UITableViewCell()
    }

}


