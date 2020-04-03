//
//  TableCell.swift
//  UI_Performance_ios
//
//  Created by NazarKo on 4/3/20.
//  Copyright © 2020 NazarKo. All rights reserved.
//

import Foundation
import UIKit

class TableCell: UITableViewCell {

    @IBOutlet private var indexLabel: UILabel!
    @IBOutlet private var rotareImageView: UIImageView!
    @IBOutlet private  var staticImageView: UIImageView!

    
    override func prepareForReuse() {
        super.prepareForReuse()
        indexLabel.text = nil
        rotareImageView.image = nil
        staticImageView.image = nil
    }

    // MARK: Cell Configuration

    func configurateTheCell(_ item: Item) {
        indexLabel.text = "\(item.index)"
        let image = UIImage(named: "\(item.index % 20).jpeg");
        rotareImageView.image = image
        staticImageView.image = image
        contentView.backgroundColor = item.color
        
        let rotation: CABasicAnimation = CABasicAnimation(keyPath: "transform.rotation.z")
        rotation.toValue = Double.pi * 2
        rotation.duration = 5.0 
        rotation.isCumulative = true
        rotation.repeatCount = Float.greatestFiniteMagnitude
        rotareImageView.layer.add(rotation, forKey: "rotationAnimation")
    }

}
