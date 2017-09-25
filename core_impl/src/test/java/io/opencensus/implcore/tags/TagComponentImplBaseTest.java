/*
 * Copyright 2017, OpenCensus Authors
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

package io.opencensus.implcore.tags;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

import io.opencensus.tags.TaggingState;
import io.opencensus.tags.TagsComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Tests for {@link TagsComponentImplBase}. */
@RunWith(JUnit4.class)
public class TagComponentImplBaseTest {
  private final TagsComponent tagsComponent = new TagsComponentImplBase();

  @Test
  public void isTaggingAvailable() {
    assertTrue(tagsComponent.isTaggingAvailable());
  }

  @Test
  public void defaultState() {
    assertThat(tagsComponent.getState()).isEqualTo(TaggingState.ENABLED);
  }

  @Test
  public void setState() {
    tagsComponent.setState(TaggingState.DISABLED);
    assertThat(tagsComponent.getState()).isEqualTo(TaggingState.DISABLED);
    tagsComponent.setState(TaggingState.ENABLED);
    assertThat(tagsComponent.getState()).isEqualTo(TaggingState.ENABLED);
  }

  @Test(expected = NullPointerException.class)
  public void setState_DisallowsNull() {
    tagsComponent.setState(null);
  }
}
