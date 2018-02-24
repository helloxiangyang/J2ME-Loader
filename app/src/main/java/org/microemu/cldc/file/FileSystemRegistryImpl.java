/**
 * MicroEmulator
 * Copyright (C) 2006-2007 Bartek Teodorczyk <barteo@barteo.net>
 * Copyright (C) 2006-2007 Vlad Skarzhevskyy
 * <p>
 * It is licensed under the following two licenses as alternatives:
 * 1. GNU Lesser General Public License (the "LGPL") version 2.1 or any newer version
 * 2. Apache License (the "AL") Version 2.0
 * <p>
 * You may not use this file except in compliance with at least one of
 * the above two licenses.
 * <p>
 * You may obtain a copy of the LGPL at
 * http://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt
 * <p>
 * You may obtain a copy of the AL at
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the LGPL or the AL for the specific language governing permissions and
 * limitations.
 *
 * @version $Id$
 */
package org.microemu.cldc.file;

import org.microemu.microedition.Implementation;

import java.util.Enumeration;

import javax.microedition.io.file.FileSystemListener;

public class FileSystemRegistryImpl implements FileSystemRegistryDelegate, Implementation {

	private String fsRoot;

	private String fsSingle;

	public FileSystemRegistryImpl() {
	}

	public FileSystemRegistryImpl(String fsRoot, String fsSingle) {
		this.fsRoot = fsRoot;
		this.fsSingle = fsSingle;
	}

	public Enumeration listRoots() {
		switch (Connection.getConnectionType()) {
			case Connection.CONNECTIONTYPE_SYSTEM_FS:
				return FileSystemFileConnection.listRoots(fsRoot, fsSingle);
			default:
				throw new RuntimeException("Invalid connectionType configuration");
		}
	}

	public boolean addFileSystemListener(FileSystemListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeFileSystemListener(FileSystemListener listener) {
		// TODO Auto-generated method stub
		return false;
	}

}
