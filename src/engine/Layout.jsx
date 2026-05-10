import MenuRenderer from './MenuRenderer';

export default function Layout({ config, children }) {
  return (
    <div style={{ display: 'flex', minHeight: '100vh' }}>
      <aside style={{ width: 240, padding: 20, borderRight: '1px solid #ddd' }}>
        <h2>{config.appName}</h2>
        <MenuRenderer menu={config.menu} />
      </aside>

      <main style={{ flex: 1, padding: 24 }}>
        {children}
      </main>
    </div>
  );
}