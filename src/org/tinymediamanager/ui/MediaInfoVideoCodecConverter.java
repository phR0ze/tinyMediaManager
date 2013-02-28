/*
 * Copyright 2012 Manuel Laggner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tinymediamanager.ui;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.jdesktop.beansbinding.Converter;

/**
 * The Class ImageIconConverter.
 */
public class MediaInfoVideoCodecConverter extends Converter<String, Icon> {

  /** The Constant emptyImage. */
  public final static ImageIcon emptyImage = new ImageIcon();

  /*
   * (non-Javadoc)
   * 
   * @see org.jdesktop.beansbinding.Converter#convertForward(java.lang.Object)
   */
  @Override
  public Icon convertForward(String arg0) {
    // try to get the image file

    // a) return null if the Format is empty
    if (StringUtils.isEmpty(arg0)) {
      return null;
    }

    try {
      StringBuilder sb = new StringBuilder("/images/mediainfo/video/");
      sb.append(arg0.toLowerCase());
      sb.append(".png");

      URL file = MediaInfoVideoCodecConverter.class.getResource(sb.toString());
      if (file != null) {
        return new ImageIcon(file);
      }

    }
    catch (Exception e) {
    }

    // we did not get any file: return the empty
    return emptyImage;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.jdesktop.beansbinding.Converter#convertReverse(java.lang.Object)
   */
  @Override
  public String convertReverse(Icon arg0) {
    return null;
  }

}