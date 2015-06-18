package org.tlc.whereat.support

import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope

/**
 * Author: @aguestuser
 * Date: 5/3/15
 * License: GPLv2 (https://www.gnu.org/licenses/gpl-2.0.html)
 */

trait BaseTestSpecification extends Specification with Mockito {

  trait BaseTestSupport extends Scope

}