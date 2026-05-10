import React, { useMemo, useState } from 'react';

import adminConfig from './config/admin';
import ccConfig from './config/cc';

const APP_NAME = import.meta.env.VITE_APP_NAME || 'admin';

const apps = {
  admin: adminConfig,
  cc: ccConfig,
};

function App() {
  const currentApp = apps[APP_NAME];

  const menuItems = useMemo(() => {
    return Object.keys(currentApp.menu).map((key) => ({
      key,
      ...currentApp.menu[key],
    }));
  }, [currentApp]);

  const [selectedPage, setSelectedPage] = useState(menuItems[0]);

  if (!currentApp) {
    return <div>Application introuvable</div>;
  }

  return (
    <div
      style={{
        display: 'flex',
        height: '100vh',
        fontFamily: 'Arial',
      }}
    >
      {/* SIDEBAR */}
      <div
        style={{
          width: 260,
          background: '#1e293b',
          color: 'white',
          padding: 20,
        }}
      >
        <h2>{currentApp.title}</h2>

        <div style={{ marginTop: 30 }}>
          {menuItems.map((item) => {
            const isActive = selectedPage.key === item.key;

            return (
              <div
                key={item.key}
                onClick={() => setSelectedPage(item)}
                style={{
                  padding: '12px 16px',
                  marginBottom: 10,
                  borderRadius: 8,
                  cursor: 'pointer',
                  background: isActive ? '#334155' : 'transparent',
                  transition: '0.2s',
                }}
              >
                <div style={{ fontWeight: 'bold' }}>
                  {item.icon} {item.label}
                </div>
              </div>
            );
          })}
        </div>
      </div>

      {/* CONTENT */}
      <div
        style={{
          flex: 1,
          padding: 30,
          background: '#f1f5f9',
        }}
      >
        <h1>{selectedPage.label}</h1>

        <div
          style={{
            marginTop: 20,
            background: 'white',
            padding: 20,
            borderRadius: 10,
            boxShadow: '0 2px 8px rgba(0,0,0,0.08)',
          }}
        >
          <p>
            <strong>Resource :</strong> {selectedPage.key}
          </p>

          <p>
            <strong>API :</strong> {import.meta.env.VITE_API_URL}
          </p>

          <p>
            <strong>App :</strong> {APP_NAME}
          </p>

          <hr />

          <h3>Contenu dynamique</h3>

          <p>
            Ici tu vas afficher :
          </p>

          <ul>
            <li>table CRUD</li>
            <li>formulaire</li>
            <li>filtres</li>
            <li>config JSON</li>
            <li>provider API</li>
          </ul>
        </div>
      </div>
    </div>
  );
}

export default App;