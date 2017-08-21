/**
 * Copyright (c) 2017 Ariel Favio Carrizo
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'esferixis' nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.esferixis.gameengine.renderengine.plane.shape;

import com.esferixis.math.Vector2f;
import com.esferixis.math.Vector4f;

/**
 * @author ariel
 *
 */
public abstract class ColorDistribution {
	public interface Visitor<V> {
		public V visit(UniformColorDistribution colorDistribution);
	}
	
	ColorDistribution() {}
	
	/**
	 * @pre El color no puede ser nulo
	 * @post Devuelve el color en la posición especificada
	 */
	public final Vector4f getColor(Vector2f position) {
		if ( position != null ) {
			return this.getColor_internal(position);
		}
		else {
			throw new NullPointerException();
		}
	}
	
	/**
	 * @pre El color no puede ser nulo
	 * @post Devuelve el color en la posición especificada
	 */
	protected abstract Vector4f getColor_internal(Vector2f position);
	
	/**
	 * @post Visita con el visitor especificado
	 */
	public abstract <V> V accept(Visitor<V> visitor);
}
