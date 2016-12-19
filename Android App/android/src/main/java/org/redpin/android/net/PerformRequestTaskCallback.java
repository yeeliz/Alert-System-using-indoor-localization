/**
 * Filename: PerformRequestTaskCallback.java (in org.repin.android.net)
 * This file is part of the Redpin project.
 * <p/>
 * Redpin is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * Redpin is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Lesser General Public License
 * along with Redpin. If not, see <http://www.gnu.org/licenses/>.
 * <p/>
 * (c) Copyright ETH Zurich, Pascal Brogle, Philipp Bolliger, 2010, ALL RIGHTS RESERVED.
 * <p/>
 * www.redpin.org
 */
package org.redpin.android.net;

/**
 * Callback Interface for {@link PerformRequestTask}
 *
 * @author Pascal Brogle (broglep@student.ethz.ch)
 *
 */
public interface PerformRequestTaskCallback {
    /**
     * Runs in background thread
     *
     * @param request
     *            {@link Request}
     * @param response
     *            {@link Response}
     * @param task
     *            The {@link PerformRequestTask} that is calling the callback
     */
    void onPerformedBackground(Request<?> request, Response<?> response,
                               PerformRequestTask task);

    /**
     * Runs in UI thread
     *
     * @param request
     *            {@link Request}
     * @param response
     *            {@link Response}
     * @param task
     *            The {@link PerformRequestTask} that is calling the callback
     */
    void onPerformedForeground(Request<?> request, Response<?> response,
                               PerformRequestTask task);

    /**
     * Runs in UI thread
     *
     * @param request
     * @param task
     *            The {@link PerformRequestTask} that is calling the callback
     */
    void onCanceledForeground(Request<?> request, PerformRequestTask task);
}